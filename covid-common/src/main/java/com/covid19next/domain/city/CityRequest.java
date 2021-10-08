package com.covid19next.domain.city;

import com.covid19next.domain.country.Country;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class CityRequest {
    @NotEmpty(message = "한국어 나라명은 필수 입니다.")
    private String cityNameKr;
    private String cityNameEn;
    @NotNull(message = "국가 정보가 누락되었습니다.")
    private Long countyId;


    @Builder
    public CityRequest(String cityNameKr, String cityNameEn, Long countyId) {
        this.cityNameKr = cityNameKr;
        this.cityNameEn = cityNameEn;
        this.countyId = countyId;
    }

    public City toEntity(Country country) {
        return City.builder()
                .nameKr(cityNameKr)
                .nameEn(cityNameEn)
                .country(country)
                .build();
    }
}
