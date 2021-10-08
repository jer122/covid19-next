package com.covid19next.domain.covidinfo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CovidInformationCountrySafetyNewsRequest {
    private int numOfRows = 10;
    private int pageNo = 1;
    private String title1 = "입국";
    private String title2 = "코로나";
    private String title3 = "출국";

    @Builder
    public CovidInformationCountrySafetyNewsRequest(int numOfRows, int pageNo, String title1, String title2, String title3) {
        this.numOfRows = numOfRows;
        this.pageNo = pageNo;
        this.title1 = title1;
        this.title2 = title2;
        this.title3 = title3;
    }
}
