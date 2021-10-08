package com.covid19next.job;

import com.covid19next.flow.covid.CovidCountriesFlow;
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
public class CovidCountriesJob {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final CovidCountriesFlow countriesFlow;


    @Bean
    public Job covidCountriesSyncJob() {
        return jobBuilderFactory.get("covidCountriesSyncJob ")
                .start(covidCountriesSyncStep(null))
//                .next(saveDataStep())
                .build();

    }

    @Bean
    @JobScope
    public Step covidCountriesSyncStep(@Value("#{jobParameters[requestDate]}") String requestDate) {
        return stepBuilderFactory.get("covidCountriesSyncStep")
                .tasklet((contribution, chunkContext) -> {
                    log.info(">>>>>>> covidCountriesSyncStep getDataStep = {}", requestDate);
//                    countriesFlow.saveDataFlow();
                    log.info(">>>>>>> covidCountriesSyncStep getDataStep END");

                    return RepeatStatus.FINISHED;
                })
                .build();
    }


}
