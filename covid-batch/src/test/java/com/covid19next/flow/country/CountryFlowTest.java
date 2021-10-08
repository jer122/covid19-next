package com.covid19next.flow.country;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;


@SpringBootTest
public class CountryFlowTest {

    @Autowired
    CountryFlow countryFlow;


    @Test
    public void getDataAndSave() {
//        int i = countryFlow.saveDataFlow();
//        System.out.println(i);
    }
}
