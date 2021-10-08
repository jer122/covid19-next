package com.covid19next.domain.covidinfo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
public class CovidInformationResponse {

    private String id;
    private String title;
    private String content;
    private String code;
    private String countryName;
    private String countryEngName;
    private String continentName;
    private String continentEngName;
    private String fileUrl;
    private String filePath;
    private LocalDateTime writeDt;


    @Builder
    public CovidInformationResponse(String id, String title, String content, String code, String countryName, String countryEngName, String continentName, String continentEngName, String fileUrl, String filePath, LocalDateTime writeDt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.code = code;
        this.countryName = countryName;
        this.countryEngName = countryEngName;
        this.continentName = continentName;
        this.continentEngName = continentEngName;
        this.fileUrl = fileUrl;
        this.filePath = filePath;
        this.writeDt = writeDt;
    }

    public CovidInformation toEntity() {
        return CovidInformation.builder()
                .noticeId(id)
                .title(title)
                .content(content)
                .code(code)
                .countryName(countryName)
                .continentName(continentName)
                .countryEngName(continentEngName)
                .fileUrl(fileUrl)
                .filePath(filePath)
                .wrtDt(writeDt)
                .build();
    }


}
