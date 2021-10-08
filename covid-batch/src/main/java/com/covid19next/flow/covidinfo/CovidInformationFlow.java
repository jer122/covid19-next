package com.covid19next.flow.covidinfo;

import com.covid19next.client.covidinfo.CovidInformationClient;
import com.covid19next.domain.country.CountryBasicListRequest;
import com.covid19next.domain.covidinfo.CovidCountrySafetyNewsListNewResponse;
import com.covid19next.domain.covidinfo.CovidInformation;
import com.covid19next.domain.covidinfo.CovidInformationCountrySafetyNewsResponse;
import com.covid19next.domain.covidinfo.CovidInformationCountrySafetyNewsRequest;
import com.covid19next.flow.BaseFlowInterface;
import com.covid19next.service.covidinfo.CovidInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CovidInformationFlow implements BaseFlowInterface {


    private final CovidInformationClient informationClient;
    private final CovidInformationService covidInformationService;


    @Override
    public int saveDataFlow() {
        List<CovidInformation> informationList = getJsonToInformation();
        return covidInformationService.saveCovidInformation(informationList);
    }

    private List<CovidInformation> getXmlToInformation() {
        return informationClient
                .getResponseData(CovidInformationCountrySafetyNewsRequest.builder()
                        .numOfRows(120)
                        .pageNo(1)
                        .title1("입국")
                        .title2("코로나")
                        .title3("출국")
                        .build()).map(items ->
                        items.getItem().stream()
                                .map(item -> new CovidInformationCountrySafetyNewsResponse(
                                        item.getId(),
                                        item.getContent(),
                                        item.getTitle())
                                )
                                .collect(Collectors.toList())
                ).orElseThrow(NullPointerException::new)
                .stream().map(CovidInformationCountrySafetyNewsResponse::toEntity)
                .collect(Collectors.toList());
    }

    private List<CovidInformation> getJsonToInformation() {
        return informationClient.getResponseJsonData(CountryBasicListRequest
                        .builder()
                        .returnType("JSON")
                        .pageNo(1)
                        .numOfRows(120)
                        .build()
                ).orElseThrow(() -> new IllegalArgumentException("No Data"))
                .stream().map(CovidCountrySafetyNewsListNewResponse.ResponseData::toEntity)
                .collect(Collectors.toList());
    }


}
