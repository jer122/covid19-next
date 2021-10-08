package com.covid19next.domain.continent;

import com.covid19next.domain.BaseTime;
import com.covid19next.domain.city.City;
import com.covid19next.domain.country.Country;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Continent extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "continent_id")
    private Long id;
    private String code;
    private String name;
    private String nameEn;
    @Lob
    private String imgUrl;

    @OneToMany(mappedBy = "continent")
    private List<Country> countrie = new ArrayList<>();

    @Builder
    public Continent(Long id, String code, String name, String nameEn, String imgUrl) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.nameEn = nameEn;
        this.imgUrl = imgUrl;
    }
}
