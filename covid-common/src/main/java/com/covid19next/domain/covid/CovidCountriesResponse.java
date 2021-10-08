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
import java.util.List;

@Data
@NoArgsConstructor
public class CovidCountriesResponse implements JsonSerializable {

    @JsonProperty("data")
    private List<CovidCountriesData> covidCountriesData;
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
        private List<CovidCountryResponse.TimeLine> timeLines;

    }

    @Data
    public static class Coordinates {
        @JsonProperty("latitude")
        private Long latitude;
        @JsonProperty("longitude")
        private Long longitude;
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
        @JsonProperty("death_rate")
        private DeathRate deathRate;
    }

    @Data
    public static class DeathRate {
        @JsonProperty("recovery_rate")
        private Long recoveryRate;
        @JsonProperty("recovered_vs_death_ratio")
        private Long recoveredVsDeathRatio;
        @JsonProperty("cases_per_million_population")
        private Long casesPerMillionPopulation;


    }


}
