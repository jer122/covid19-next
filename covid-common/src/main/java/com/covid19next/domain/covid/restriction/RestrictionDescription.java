package com.covid19next.domain.covid.restriction;

import com.covid19next.domain.country.Country;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class RestrictionDescription {

    @Id
    @Column(name = "desc_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Lob
    private String description;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code")
    private CovidCountryRestriction covidCountryRestriction;

    @Builder
    public RestrictionDescription(Long id, String description, CovidCountryRestriction covidCountryRestriction) {
        this.id = id;
        this.description = description;
        this.covidCountryRestriction = covidCountryRestriction;
    }
}
