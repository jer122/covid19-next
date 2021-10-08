package com.covid19next.domain.covid.status;

import com.covid19next.domain.BaseTime;
import com.covid19next.domain.continent.Continent;
import com.covid19next.domain.country.Country;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class CovidStatusGlobal {

    @EmbeddedId
    private CovidStatusGlobalId statusGlobalId;
    private String countryName;
    @CreatedDate
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long population;
    private Long todayDeaths;
    private Long todayConfirmed;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "covidStatusGlobal")
    private List<CovidGlobalLatest> covidGlobalLatest = new ArrayList<>();

    public void countrySync(Country country) {
        this.country = country;
    }


//    private CovidGlobalLatest covidGlobalLatest;


    @Builder
    public CovidStatusGlobal(CovidStatusGlobalId statusGlobalId, String countryName, LocalDateTime createdAt, LocalDateTime updatedAt, Long population, Long todayDeaths, Long todayConfirmed, Country country, List<CovidGlobalLatest> covidGlobalLatest) {
        this.statusGlobalId = statusGlobalId;
        this.countryName = countryName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.population = population;
        this.todayDeaths = todayDeaths;
        this.todayConfirmed = todayConfirmed;
        this.country = country;
        this.covidGlobalLatest = covidGlobalLatest;
    }

    @Data
    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CovidStatusGlobalId implements Serializable {
        @Column(name = "status_id")
        private Long id;
        private String code;


    }

}
