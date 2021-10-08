package com.covid19next.domain.city;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CityListResponse {
    List<String> korCites;
    List<String> engCites;
    int count;
    Long city_id;

    @Builder
    public CityListResponse(List<String> korCites, List<String> engCites) {
        this.korCites = korCites;
        this.engCites = engCites;
    }


}
