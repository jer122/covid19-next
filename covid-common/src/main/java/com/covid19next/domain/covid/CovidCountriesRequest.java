package com.covid19next.domain.covid;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CovidCountriesRequest {
    private String code;

    @Builder
    public CovidCountriesRequest(String code) {
        this.code = code;
    }
}
