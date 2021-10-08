package com.covid19next.client.countyinfo;

import com.covid19next.client.BaseClient;
import com.covid19next.client.BaseClientFacade;
import com.covid19next.domain.country.CountryBasicListRequest;
import com.covid19next.model.countryinfo.CountryInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Component
@Slf4j
public class CountryInformationClient extends BaseClient implements BaseClientFacade<CountryInfo, CountryBasicListRequest> {

    @Value("${openapi.service-key}")
    private String serviceKey;

    private final WebClient webClient;
    public CountryInformationClient(@Qualifier("batchClient") WebClient webClient) {
        this.webClient = webClient;
    }

    // json to java object
    public Optional<CountryInfo> getResponseData(CountryBasicListRequest requestDto) {
        log.info("CountryInformationClient getResponseData  -> {}", requestDto);
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/CountryGnrlInfoService2/getCountryGnrlInfoList2")
                        .queryParam("serviceKey", serviceKey)
                        .queryParam("returnType", requestDto.getReturnType())
                        .queryParam("pageNo", requestDto.getPageNo())
                        .queryParam("numOfRows", requestDto.getNumOfRows())
                        .queryParam("cond[country_nm::EQ]", queryParamEncodingBuilder(requestDto.getCond()))
                        .build()
                )
                .retrieve()
                .bodyToMono(CountryInfo.class)
                .blockOptional();

    }


}