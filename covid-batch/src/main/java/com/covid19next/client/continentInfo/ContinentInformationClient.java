package com.covid19next.client.continentInfo;

import com.covid19next.client.BaseClient;
import com.covid19next.client.BaseClientFacade;
import com.covid19next.domain.continent.ContinentClientRequest;
import com.covid19next.domain.country.CountryBasicListRequest;
import com.covid19next.model.continentInfo.ContinentResponse;
import com.covid19next.model.countryinfo.CountryInfo;
import com.covid19next.model.covidinfo.CovidInformationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Component
@Slf4j
public class ContinentInformationClient extends BaseClient implements BaseClientFacade<ContinentResponse.Body.Items, ContinentClientRequest> {

    @Value("${openapi.service-key}")
    private String serviceKey;

    private final WebClient webClient;

    public ContinentInformationClient(@Qualifier("batchClient") WebClient webClient) {
        this.webClient = webClient;
    }

    // xml to java object
    public Optional<ContinentResponse.Body.Items> getResponseData(ContinentClientRequest requestDto) {
        log.info("ContinentInformationClient getResponseData  -> {}", requestDto);
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/CountryCodeService/getCountryCodeList")
                                .queryParam("serviceKey", serviceKey)
                                .queryParam("pageNo", requestDto.getPageNo())
                                .queryParam("numOfRows", requestDto.getNumOfRows())
//                        .queryParam("continent", queryParamEncodingBuilder(requestDto.getContinent()))
                                .build()
                )
                .retrieve()
                .bodyToMono(ContinentResponse.class)
                .map(ContinentResponse::getBody)
                .map(ContinentResponse.Body::getItems)
                .blockOptional();
    }
}