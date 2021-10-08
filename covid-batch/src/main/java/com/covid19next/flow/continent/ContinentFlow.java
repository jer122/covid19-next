package com.covid19next.flow.continent;

import com.covid19next.client.continentInfo.ContinentInformationClient;
import com.covid19next.client.covidinfo.CovidInformationClient;
import com.covid19next.domain.continent.Continent;
import com.covid19next.domain.continent.ContinentClientRequest;
import com.covid19next.domain.continent.ContinentClientResponse;
import com.covid19next.domain.country.Country;
import com.covid19next.domain.covidinfo.CovidInformation;
import com.covid19next.domain.covidinfo.CovidInformationCountrySafetyNewsRequest;
import com.covid19next.domain.covidinfo.CovidInformationCountrySafetyNewsResponse;
import com.covid19next.service.continent.ContinentService;
import com.covid19next.service.covidinfo.CovidInformationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class ContinentFlow {
    private final ContinentInformationClient informationClient;
    private final ContinentService continentService;


    public int saveDataFlow() {

        //국가 api call
        List<Continent> continents = getInformation();

        //국가 API 데이터 저장
        log.info("ContinentFlow saveDataFlow Start");
        int size = continentService.saveAll(continents);

        log.info("ContinentFlow saveDataFlow End");

        return size;
    }

    private List<Continent> getInformation() {
        return informationClient
                .getResponseData(ContinentClientRequest.builder()
                        .numOfRows(10)
                        .pageNo(1)
                        .build()).map(items ->
                        items.getItem().stream()
                                .map(item -> new ContinentClientResponse(
                                        item.getCode(),
                                        item.getContinent())
                                )
                                .collect(Collectors.toList())
                ).orElseThrow(NullPointerException::new)
                .stream().map(ContinentClientResponse::toEntity)
                .collect(Collectors.toList());
    }

}
