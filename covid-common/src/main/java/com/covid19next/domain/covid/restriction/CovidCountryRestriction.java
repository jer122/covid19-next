package com.covid19next.domain.covid.restriction;

import com.covid19next.domain.BaseTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class CovidCountryRestriction extends BaseTime {

    @Id
    @Column(name = "country_code")
    private String code;
    @Column(name = "country_name")
    private String name;
    @Enumerated(EnumType.STRING)
    private RestrictionType restrictionType;


    @OneToMany(mappedBy = "covidCountryRestriction")
    private List<RestrictionDescription> restrictionDescription = new ArrayList<>();

    @Builder
    public CovidCountryRestriction(String code, String name, RestrictionType restrictionType, List<RestrictionDescription> restrictionDescription) {
        this.code = code;
        this.name = name;
        this.restrictionType = restrictionType;
        this.restrictionDescription = restrictionDescription;
    }
}
