package com.covid19next.client.countyinfo;

import com.covid19next.domain.country.CountryBasicListRequest;
import com.covid19next.model.countryinfo.CountryData;
import com.covid19next.model.countryinfo.CountryInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryCityInformationClientTest {

    @Autowired
    CountryInformationClient informationClient;


    @Test
    public void clientCallTest() {
        //given,when
        String mainCities = informationClient.getResponseData(CountryBasicListRequest.builder()
                        .numOfRows(1)
                        .pageNo(1)
                        .returnType("JSON")
                        .cond("기니")
                        .build())
                .filter(countryInfo -> countryInfo.getTotalCount() > 0)
                .map(countryInfo -> countryInfo.getData().stream().map(CountryData::getMain_city_cn)
                        .collect(Collectors.joining())
                )
                .orElse(null);

        //then
        Assert.assertNotNull(mainCities);

    }
}