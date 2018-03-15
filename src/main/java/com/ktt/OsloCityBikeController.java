package com.ktt;

import com.ktt.model.Root;
import com.ktt.model.Station;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

import static java.util.Collections.singletonList;

@RestController
public class OsloCityBikeController {

    @Value("${ocb.api.base.url}")
    private String ocbApiBaseUrl;

    @Value("${ocb.api.key}")
    private String ocbApiKey;

    private RestTemplate restTemplate;

    @PostConstruct
    public void init() {
        restTemplate = new RestTemplate();
        restTemplate.setInterceptors(singletonList(
                new HttpRequestHeaderInterceptor("client-identifier", ocbApiKey)));
    }

    @RequestMapping(value = "/stations")
    public Station[] stations() {
        String getStationListUrl = ocbApiBaseUrl + "/stations";
        String getAvailableListUrl = ocbApiBaseUrl + "/stations/availability";

        Root stationList = restTemplate.getForObject(getStationListUrl, Root.class);
        Root availabilityList = restTemplate.getForObject(getAvailableListUrl, Root.class);

        for (Station station : stationList.getStations()) {
            for (Station availability : availabilityList.getStations()) {
                if (station.getId().equals(availability.getId())) {
                    station.setAvailability(availability.getAvailability());
                }
            }
        }
        return stationList.getStations();
    }
}
