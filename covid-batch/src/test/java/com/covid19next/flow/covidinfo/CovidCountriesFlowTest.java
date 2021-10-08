package com.covid19next.flow.covidinfo;

import com.covid19next.flow.covid.CovidCountriesFlow;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CovidCountriesFlowTest {

    @Autowired
    CovidCountriesFlow covidCountriesFlow;


    @Test
    public void testFlow() throws Exception {
        covidCountriesFlow.saveCovidStatusGlobal();
    }


    @Test
    public void testLocalDateToLong() throws Exception {
        //given
        LocalDateTime localDateTime = LocalDateTime.parse("2021-10-04 04:21:31", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        //when
        long time = Timestamp.valueOf(localDateTime).getTime();

        //then
        //1633288891000
        Assert.assertEquals(time, 1633288891000L);
        System.out.println(time);

    }
}