package com.covid19next.client.covidinfo;

import com.covid19next.domain.country.CountryBasicListRequest;
import com.covid19next.domain.covidinfo.CovidCountrySafetyNewsListNewResponse;
import com.covid19next.domain.covidinfo.CovidInformation;
import com.covid19next.domain.covidinfo.CovidInformationCountrySafetyNewsRequest;
import com.covid19next.domain.covidinfo.CovidInformationCountrySafetyNewsResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CovidInformationClientTest {

    @Autowired
    CovidInformationClient covidInformationClient;

    CovidInformationCountrySafetyNewsRequest safetyNewsRequest;

    @BeforeEach
    public void setUp() {
        this.safetyNewsRequest = new CovidInformationCountrySafetyNewsRequest(10, 1, "입국", "코로나", "출국");
    }


    @Test
    public void getDataMonoTest() {
        //given
        System.out.println(safetyNewsRequest);

        //when
        List<CovidInformation> dataResponseItems = covidInformationClient
                .getResponseData(safetyNewsRequest)
                .map(items ->
                        items.getItem().stream()
                                .map(item -> new CovidInformationCountrySafetyNewsResponse(item.getId().trim(), item.getContent(), item.getTitle()))
                                .collect(Collectors.toList())

                )
                .orElseThrow(NullPointerException::new)
                .stream()
                .map(CovidInformationCountrySafetyNewsResponse::toEntity)
                .collect(Collectors.toList());


        //then
        System.out.println(dataResponseItems);
        assertFalse(dataResponseItems.isEmpty());
    }

    @Test
    public void testGetResponseJsonData() {

        //given
        CountryBasicListRequest countryBasicListRequest = CountryBasicListRequest.builder()
                .returnType("JSON")
                .numOfRows(120)
                .pageNo(1)
                .build();
        //when
        List<CovidCountrySafetyNewsListNewResponse.ResponseData> data_not_found = covidInformationClient
                .getResponseJsonData(countryBasicListRequest)
                .orElseThrow(() -> new IllegalArgumentException("Data Not Found"));

        //then
        assertTrue(data_not_found.size() > 0);

    }

}