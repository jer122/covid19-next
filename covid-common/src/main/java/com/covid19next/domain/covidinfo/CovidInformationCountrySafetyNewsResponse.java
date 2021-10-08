package com.covid19next.domain.covidinfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.sql.Blob;

@Data
@NoArgsConstructor
public class CovidInformationCountrySafetyNewsResponse{

    private String id;
    private String content;
    private String title;


    public CovidInformationCountrySafetyNewsResponse(String id, String content, String title) {
        this.id = id;
        this.content = content;
        this.title = title;
    }

    public CovidInformation toEntity() {
        return CovidInformation.builder()
                .content(content)
                .title(title)
//                .infoType(InfoType.ENTRY)
                .build();
    }
    

}
