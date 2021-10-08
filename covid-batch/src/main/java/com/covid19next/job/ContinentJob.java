package com.covid19next.job;

import com.covid19next.flow.continent.ContinentFlow;
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
public class ContinentJob {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final ContinentFlow continentFlow;


    @Bean
    public Job continentBaseJob() {
        return jobBuilderFactory.get("continentBaseJob")
                .start(saveContinentStep(null))
                .build();

    }

    @Bean
    @JobScope
    public Step saveContinentStep(@Value("#{jobParameters[requestDate]}") String requestDate) {
        return stepBuilderFactory.get("saveContinentStep")
                .tasklet((contribution, chunkContext) -> {
                    log.info(">>>>>>> continentJob saveContinentStep = {}", requestDate);
//                    continentFlow.saveDataFlow();
                    log.info(">>>>>>> continentJob saveContinentStep END");

                    return RepeatStatus.FINISHED;
                })
                .build();
    }
}
