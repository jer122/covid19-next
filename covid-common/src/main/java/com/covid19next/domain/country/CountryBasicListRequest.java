package com.covid19next.domain.country;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountryBasicListRequest {
    private int numOfRows;
    private int pageNo;
    private String returnType;
    private String cond;

    @Builder
    public CountryBasicListRequest(int numOfRows, int pageNo, String returnType, String cond) {
        this.numOfRows = numOfRows;
        this.pageNo = pageNo;
        this.returnType = returnType;
        this.cond = cond;
    }

    public CountryBasicListRequest(int numOfRows, int pageNo, String returnType) {
        this.numOfRows = numOfRows;
        this.pageNo = pageNo;
        this.returnType = returnType;
    }
}
