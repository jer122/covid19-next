package com.covid19next.domain.covid;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class CovidCountryResponse implements JsonSerializable {

    @JsonProperty("data")
    private CovidCountriesData covidCountriesData;
    @JsonProperty("cacheHit")
    private boolean cacheHit;


    @Override
    public void serialize(JsonGenerator gen, SerializerProvider serializers) throws IOException {

    }

    @Override
    public void serializeWithType(JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {

    }

    @Data
    public static class CovidCountriesData {

        @JsonProperty("coordinates")
        private Coordinates coordinates;

        @JsonProperty("code")
        private String code;

        @JsonProperty("name")
        private String name;

        @JsonProperty("population")
        private Long population;

        @JsonProperty("updated_at")
        private LocalDateTime updatedAt;

        @JsonProperty("today")
        private Today today;

        @JsonProperty("latest_data")
        private LatestData latestData;

        @JsonProperty("timeline")
        private List<TimeLine> timeLines;
    }

    @Data
    public static class Coordinates {
        @JsonProperty("latitude")
        private double latitude;
        @JsonProperty("longitude")
        private double longitude;
    }

    @Data
    public static class Today {
        @JsonProperty("deaths")
        private Long deaths;
        @JsonProperty("confirmed")
        private Long confirmed;
    }

    @Data
    public static class LatestData {
        @JsonProperty("deaths")
        private Long deaths;
        @JsonProperty("confirmed")
        private Long confirmed;
        @JsonProperty("recovered")
        private Long recovered;
        @JsonProperty("critical")
        private Long critical;
        @JsonProperty("calculated")
        private Calculated calculated;
    }

    @Data
    public static class Calculated {
        //        "death_rate": 0.9693053311793215,
//                "recovery_rate": 18.174474959612276,
//                "recovered_vs_death_ratio": null,
//                "cases_per_million_population": 0
        @JsonProperty("death_rate")
        private double deathRate;
        @JsonProperty("recovery_rate")
        private double recoveryRate;
        @JsonProperty("cases_per_million_population")
        private Long casesPerMillionPopulation;
    }

    @Data
    public static class DeathRate {
        @JsonProperty("recovery_rate")
        private double recoveryRate;
        @JsonProperty("recovered_vs_death_ratio")
        private double recoveredVsDeathRatio;
        @JsonProperty("cases_per_million_population")
        private Long casesPerMillionPopulation;

    }

    @Data
    public static class TimeLine {
        @JsonProperty("updated_at")
        private LocalDateTime updatedAt;
        @JsonProperty("date")
        private Date date;
        @JsonProperty("deaths")
        private Long deaths;
        @JsonProperty("confirmed")
        private Long confirmed;
        @JsonProperty("recovered")
        private Long recovered;
        @JsonProperty("new_confirmed")
        private Long newConfirmed;
        @JsonProperty("new_recovered")
        private Long newRecovered;
        @JsonProperty("new_deaths")
        private Long newDeaths;
        @JsonProperty("active")
        private Long active;
    }


}
