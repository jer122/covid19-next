package com.covid19next.domain.city;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CityResponse {
    private Long cityId;
    private String cityNameKr;
    private String cityNameEn;
    private Long countyId;

    @Builder
    public CityResponse(City city) {
        this.cityId = city.getId();
        this.cityNameKr = city.getNameKr();
        this.cityNameEn = city.getNameEn();
        this.countyId = city.getCountry().getId();
    }
}
