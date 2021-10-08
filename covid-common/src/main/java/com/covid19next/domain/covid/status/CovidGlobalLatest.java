package com.covid19next.domain.covid.status;

import com.covid19next.domain.continent.Continent;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class CovidGlobalLatest {
    //deaths
//confirmed
//recovered
//critical
//calculatedDeathRate
//calculatedRecoveryRate
//calculatedRecoveredVsDeathRatio
//calculatedCasesPerMillionPopulation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long deaths;
    private Long confirmed;
    private Long recovered;
    private Long critical;
    private Double calculatedDeathRate;
    private Double calculatedRecoveryRate;
    private Double calculatedRecoveredVsDeathRatio;
    private Double calculatedCasesPerMillionPopulation;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    @JoinColumn(name = "code")
    private CovidStatusGlobal covidStatusGlobal;


    @Builder
    public CovidGlobalLatest(Long id,
                             Long deaths,
                             Long confirmed,
                             Long recovered,
                             Long critical,
                             Double calculatedDeathRate,
                             Double calculatedRecoveryRate,
                             Double calculatedRecoveredVsDeathRatio,
                             Double calculatedCasesPerMillionPopulation) {
        this.id = id;
        this.deaths = deaths;
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.critical = critical;
        this.calculatedDeathRate = calculatedDeathRate;
        this.calculatedRecoveryRate = calculatedRecoveryRate;
        this.calculatedRecoveredVsDeathRatio = calculatedRecoveredVsDeathRatio;
        this.calculatedCasesPerMillionPopulation = calculatedCasesPerMillionPopulation;
    }
}
