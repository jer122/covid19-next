package com.covid19next.domain.country;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountyBasicListResponse {
    private Long id;
    private String continent;
    private String imgUrl;
    private String nameKr;
    private String nameEn;

    @Builder
    public CountyBasicListResponse(Long id, String continent, String nameKr, String nameEn, String imgUrl) {
        this.id = id;
        this.continent = continent;
        this.imgUrl = imgUrl;
        this.nameKr = nameKr;
        this.nameEn = nameEn;
    }

    @Builder
    public Country toEntity() {
        return Country.builder()
                .id(id)
                .nameKr(nameKr)
                .nameEn(nameEn)
                .continentNameKr(continent)
                .imgUrl(imgUrl)
                .build();
    }
}
