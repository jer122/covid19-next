package com.covid19next.domain.continent;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContinentClientResponse {


    private Long id;
    private String code;
    private String continent;
    private String name;
    private String imgUrl;

    @Builder
    public ContinentClientResponse(Long id, String code, String continent, String name, String imgUrl) {
        this.id = id;
        this.code = code;
        this.continent = continent;
        this.name = name;
        this.imgUrl = imgUrl;
    }

    public ContinentClientResponse(String code, String continent) {
        this.code = code;
        this.continent = continent;
    }

    public Continent toEntity() {
        return Continent.builder()
                .code(code)
                .name(continent)
                .build();
    }
}
