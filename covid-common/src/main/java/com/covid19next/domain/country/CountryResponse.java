package com.covid19next.domain.country;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CountryResponse {
    private Long countryId;
    private String code;
    private String countryNameKr;
    private String countryNameEn;
    private String imgUrl;

    @Builder
    public CountryResponse(Long countryId, String code, String countryNameKr, String countryNameEn, String imgUrl) {
        this.countryId = countryId;
        this.code = code;
        this.countryNameKr = countryNameKr;
        this.countryNameEn = countryNameEn;
        this.imgUrl = imgUrl;
    }


}
