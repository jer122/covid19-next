package com.covid19next.domain.country;


import com.covid19next.domain.BaseTime;
import com.covid19next.domain.city.City;
import com.covid19next.domain.continent.Continent;
import com.covid19next.domain.covidinfo.CovidInformation;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Country extends BaseTime {

    @Id
    @Column(name = "country_id")
//    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String nameKr;

    private String nameEn;

    @Column(unique = true)
    private String code;

    private String continentNameKr;

    private String continentNameEn;

    @Lob
    private String imgUrl;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<CovidInformation> covidInformation = new ArrayList<>();

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<City> cities = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "continent_id")
    private Continent continent;

    @OneToOne
    @JoinColumn(name = "coordinate_id")
    private CountryCoordinates countryCoordinates;

    public void codeSync(String code) {
        this.code = code;
    }

    @Builder
    public Country(Long id, String nameKr, String nameEn, String code, String continentNameKr, String continentNameEn, String imgUrl) {
        this.id = id;
        this.nameKr = nameKr;
        this.nameEn = nameEn;
        this.code = code;
        this.continentNameKr = continentNameKr;
        this.continentNameEn = continentNameEn;
        this.imgUrl = imgUrl;
    }
}
