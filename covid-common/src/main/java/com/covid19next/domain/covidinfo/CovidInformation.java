package com.covid19next.domain.covidinfo;


import com.covid19next.domain.BaseTime;
import com.covid19next.domain.country.Country;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class CovidInformation extends BaseTime {

    @Id
    private String noticeId;
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "covid_info_id")
//    private Long id;


    private String title;

    @Lob
    private String content;

    private String code;
    private String countryName;
    private String countryEngName;
    private String continentName;
    private String continentEngName;
    private String fileUrl;
    private String filePath;
    private LocalDateTime wrtDt;

    @Enumerated(EnumType.STRING)
    private InfoType infoType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;


    @Builder
    public CovidInformation(String noticeId, String title, String content, String code, String countryName, String countryEngName, String continentName, String continentEngName, String fileUrl, String filePath, LocalDateTime wrtDt, InfoType infoType) {
        this.noticeId = noticeId;
        this.title = title;
        this.content = content;
        this.code = code;
        this.countryName = countryName;
        this.countryEngName = countryEngName;
        this.continentName = continentName;
        this.continentEngName = continentEngName;
        this.fileUrl = fileUrl;
        this.filePath = filePath;
        this.wrtDt = wrtDt;
        this.infoType = infoType;
    }
}
