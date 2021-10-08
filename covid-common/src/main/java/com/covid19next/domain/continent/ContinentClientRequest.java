package com.covid19next.domain.continent;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContinentClientRequest {
    private int numOfRows;
    private int pageNo;
    private String continent;

    @Builder
    public ContinentClientRequest(int numOfRows, int pageNo, String continent) {
        this.numOfRows = numOfRows;
        this.pageNo = pageNo;
        this.continent = continent;
    }
}
