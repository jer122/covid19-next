package com.covid19next.client.countybasic;

import com.covid19next.client.BaseClient;
import com.covid19next.client.BaseClientFacade;
import com.covid19next.domain.country.CountryBasicListRequest;
import com.covid19next.exception.RestException;
import com.covid19next.model.OpenAPIServiceResponse;
import com.covid19next.model.countryinfo.CountryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Component
@Slf4j
public class CountyBasicClient extends BaseClient implements BaseClientFacade<CountryResponse.Body.Items, CountryBasicListRequest> {

    @Value("${openapi.service-key}")
    private String serviceKey;

    private final WebClient webClient;

    public CountyBasicClient(WebClient webClient) {
        this.webClient = webClient;
    }

    // xml to java object
    public Optional<CountryResponse.Body.Items> getResponseData(CountryBasicListRequest requestDto) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/CountryBasicService/getCountryBasicList")
                        .queryParam("serviceKey", serviceKey)
                        .queryParam("numOfRows", requestDto.getNumOfRows())
                        .queryParam("pageNo", requestDto.getPageNo())
                        .build()
                )
                .retrieve()
                .bodyToMono(CountryResponse.class)
                .map(CountryResponse::getBody)
                .map(CountryResponse.Body::getItems)
                .blockOptional();
    }

    public boolean httpResponseXml(HttpStatus httpStatus) {
        boolean xxSuccessful = httpStatus.is2xxSuccessful();

        log.info("httpResponseXml value -> {} ", httpStatus.value());
        log.info("httpResponseXml value2 -> {} ", HttpStatus.METHOD_NOT_ALLOWED.value());
//        httpStatus.
        log.info("httpResponseXml -> {}", xxSuccessful);
        return false;

    }


}
