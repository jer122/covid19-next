package com.covid19next.flow.countryinfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryInformationFlowTest {

    @Autowired
    CountryInformationFlow countryInformationFlow;

    @Test
    public void testFlow() throws Exception {
//        int i = countryInformationFlow.saveDataFlow();
//        System.out.println(i);
    }
}