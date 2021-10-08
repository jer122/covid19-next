package com.covid19next.domain.covid;

import com.covid19next.domain.Result;
import com.covid19next.domain.covidlevel.CovidLevelCountryResponse;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CovidContinentResponse {
    private Long totalCount;
    private Result<List<CovidLevelCountryResponse>> asia;
    private Result<List<CovidLevelCountryResponse>> africa;
    private Result<List<CovidLevelCountryResponse>> europe;
    private Result<List<CovidLevelCountryResponse>> america;

    @Builder
    public CovidContinentResponse(
            Result<List<CovidLevelCountryResponse>> asia,
            Result<List<CovidLevelCountryResponse>> africa,
            Result<List<CovidLevelCountryResponse>> europe,
            Result<List<CovidLevelCountryResponse>> america,
            Long totalCount) {
        this.asia = asia;
        this.africa = africa;
        this.europe = europe;
        this.america = america;
        this.totalCount = totalCount;
    }

}
