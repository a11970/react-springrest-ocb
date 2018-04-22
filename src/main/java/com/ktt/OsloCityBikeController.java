package com.ktt;

import com.ktt.model.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OsloCityBikeController {

    @Autowired
    private OsloCityBikeService osloCityBikeService;

    @RequestMapping(value = "/stations")
    public Station[] stations() {
        return osloCityBikeService.getStations();
    }
}
