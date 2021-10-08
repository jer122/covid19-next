package com.covid19next.job;

import com.covid19next.flow.covid.CovidCountriesFlow;
import com.covid19next.flow.covidinfo.CovidInformationFlow;
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
public class CovidInformationJob {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final CovidInformationFlow covidInformationFlow;
    private final CovidCountriesFlow covidCountriesFlow;


    @Bean
    public Job covidInfoJob() {
        return jobBuilderFactory.get("covidInformationJob ")
                .start(saveCovidDataStep(null))
                .next(saveCovidStatusGlobalStep(null))
                .build();

    }

    @Bean
    @JobScope
    public Step saveCovidDataStep(@Value("#{jobParameters[requestDate]}") String requestDate) {
        return stepBuilderFactory.get("saveCovidDataStep")
                .tasklet((contribution, chunkContext) -> {
                    log.info(">>>>>>> CovidInformation saveDataFlow = {}", requestDate);
                    covidInformationFlow.saveDataFlow();
                    log.info(">>>>>>> CovidInformation saveDataFlow END");

                    return RepeatStatus.FINISHED;
                })
                .build();
    }


    @Bean
    @JobScope
    public Step saveCovidStatusGlobalStep(@Value("#{jobParameters[requestDate]}") String requestDate) {
        return stepBuilderFactory.get("saveCovidStatusGlobalStep")
                .tasklet((contribution, chunkContext) -> {

                    log.info(">>>>>>>> CovidInformation saveCovidStatusGlobalStep START");
                    covidCountriesFlow.saveCovidStatusGlobal();
                    log.info(">>>>>>> CovidInformation saveCovidStatusGlobalStep END");

                    return RepeatStatus.FINISHED;
                })
                .build();

    }

}
