package com.ktt;

import com.ktt.model.Availability;
import com.ktt.model.Station;
import org.junit.Before;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.BDDMockito.given;

public class TestSupport {

    protected final static Station station1 = new Station("1", "Gata 1", "Første stasjon", "true", "30", new Availability("8", "22"));
    protected final static Station station2 = new Station("2", "Gata 2", "Etter stasjon 1", "true", "24", new Availability("0", "23"));
    protected final static Station station3 = new Station("3", "Gata 3", "Etter stasjon 2", "false", "21", new Availability("0", "21"));

    @MockBean
    private OsloCityBikeService osloCityBikeService;

    @Before
    public void initMockData() {
        Station[] stations = new Station[]{station1, station2, station3};
        given(osloCityBikeService.getStations()).willReturn(stations);
    }
}
