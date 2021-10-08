package com.covid19next.flow.country;

import com.covid19next.client.countybasic.CountyBasicClient;
import com.covid19next.domain.country.Country;
import com.covid19next.domain.country.CountryBasicListRequest;
import com.covid19next.domain.country.CountyBasicListResponse;
import com.covid19next.flow.BaseFlowInterface;
import com.covid19next.service.country.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class CountryFlow implements BaseFlowInterface {


    private final CountyBasicClient countyBasicClient;
    private final CountryService countryService;


    public int saveDataFlow() {

        //국가 api call
        List<Country> countries = getCountries();

        //국가 API 데이터 저장
        log.info("CountryFlow saveDataFlow Start");
        int size = countryService.saveCountries(countries).size();

        log.info("CountryFlow saveDataFlow End");

        return size;
    }

    private List<Country> getCountries() {
        return countyBasicClient
                .getResponseData(CountryBasicListRequest.builder()
                        .numOfRows(200)
                        .pageNo(1)
                        .build()).map(items ->
                        items.getItem().stream()
                                .map(item -> new CountyBasicListResponse(
                                        (long) item.getId(),
                                        item.getContinent(),
                                        item.getCountryName(),
                                        item.getCountryEnName(),
                                        item.getImgUrl()))
                                .collect(Collectors.toList())
                ).orElseThrow(NullPointerException::new)
                .stream().map(CountyBasicListResponse::toEntity)
                .collect(Collectors.toList());
    }


}
