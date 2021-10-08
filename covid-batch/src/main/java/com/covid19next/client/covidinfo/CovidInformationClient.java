package com.covid19next.client.covidinfo;

import com.covid19next.client.BaseClient;
import com.covid19next.client.BaseClientFacade;
import com.covid19next.domain.country.CountryBasicListRequest;
import com.covid19next.domain.covidinfo.CovidCountrySafetyNewsListNewResponse;
import com.covid19next.domain.covidinfo.CovidInformationCountrySafetyNewsRequest;
import com.covid19next.model.covidinfo.CovidInformationResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Component
public class CovidInformationClient extends BaseClient implements BaseClientFacade<CovidInformationResponse.Body.Items, CovidInformationCountrySafetyNewsRequest> {

    @Value("${openapi.service-key}")
    private String serviceKey;

    private final WebClient webClient;

    public CovidInformationClient(@Qualifier("batchClient") WebClient webClient) {
        this.webClient = webClient;
    }


    // xml to java object
    public Optional<CovidInformationResponse.Body.Items> getResponseData(CovidInformationCountrySafetyNewsRequest covidInformationRequestDto) {

        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/SafetyNewsList/getCountrySafetyNewsList")
                        .queryParam("serviceKey", serviceKey)
                        .queryParam("numOfRows", covidInformationRequestDto.getNumOfRows())
                        .queryParam("pageNo", covidInformationRequestDto.getPageNo())
                        .queryParam("title1", queryParamEncodingBuilder(covidInformationRequestDto.getTitle1()))
                        .queryParam("title2", queryParamEncodingBuilder(covidInformationRequestDto.getTitle2()))
                        .queryParam("title3", queryParamEncodingBuilder(covidInformationRequestDto.getTitle3()))
                        .build()
                )
                .retrieve()
                .bodyToMono(CovidInformationResponse.class)
                .map(CovidInformationResponse::getBody)
                .map(CovidInformationResponse.Body::getItems)
                .blockOptional();
    }

    public Optional<List<CovidCountrySafetyNewsListNewResponse.ResponseData>> getResponseJsonData(CountryBasicListRequest countryBasicListRequest) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/CountryCovid19SafetyServiceNew/getCountrySafetyNewsListNew")
                        .queryParam("serviceKey", serviceKey)
                        .queryParam("returnType", countryBasicListRequest.getReturnType())
                        .queryParam("numOfRows", countryBasicListRequest.getNumOfRows())
                        .queryParam("pageNo", countryBasicListRequest.getPageNo())
                        .build()
                )
                .retrieve()
                .bodyToMono(CovidCountrySafetyNewsListNewResponse.class)
                .map(CovidCountrySafetyNewsListNewResponse::getDataList)
                .blockOptional();

    }


}