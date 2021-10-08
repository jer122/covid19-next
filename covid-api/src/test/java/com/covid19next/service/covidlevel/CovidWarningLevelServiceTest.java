package com.covid19next.service.covidlevel;

import com.covid19next.client.covid.CovidCountriesClient;
import com.covid19next.domain.covidinfo.CovidLevelCountry;
import com.covid19next.repository.covid.restriction.CovidCountryRestrictionRepository;
import com.covid19next.repository.covidlevel.CovidWarningLevelRepository;
import com.covid19next.service.covid.restriction.CovidCountryRestrictionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static reactor.core.publisher.Mono.when;

@ExtendWith(MockitoExtension.class)
class CovidWarningLevelServiceTest {

    @InjectMocks
    CovidWarningLevelService covidWarningLevelService;
    @InjectMocks
    CovidCountryRestrictionService covidCountryRestrictionService;

    @Mock
    CovidWarningLevelRepository warningLevelRepository;
    @Mock
    CovidCountryRestrictionRepository covidCountryRestrictionRepository;

    @Mock
    CovidCountriesClient covidCountriesClient;
    private List<Long> levels = new ArrayList<>(Arrays.asList(1L, 2L));


    @Test
    void getData() throws Exception {
        //given
        List<CovidLevelCountry> byCountryCovidLevel = warningLevelRepository.findByContinentCovidLevelCountriesCovidLevel(levels);
        //when

        //then

    }
}