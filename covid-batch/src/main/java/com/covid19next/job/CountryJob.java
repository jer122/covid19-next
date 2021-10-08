package com.covid19next.job;

import com.covid19next.flow.country.CountryFlow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CountryJob {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final CountryFlow countryFlow;


    @Bean
    public Job countryInfoJob() {
        return jobBuilderFactory.get("countryInformationJob ")
                .start(saveCountryDataStep(null))
//                .next(saveDataStep())
                .build();

    }

    @Bean
    @JobScope
    public Step saveCountryDataStep(@Value("#{jobParameters[requestDate]}") String requestDate) {
        return stepBuilderFactory.get("countryGetDataStep")
                .tasklet((contribution, chunkContext) -> {
                    log.info(">>>>>>> CountryInformationJob getDataStep = {}", requestDate);
//                    countryFlow.saveDataFlow();
                    log.info(">>>>>>> CountryInformationJob getDataStep END");

                    return RepeatStatus.FINISHED;
                })
                .build();
    }


}
