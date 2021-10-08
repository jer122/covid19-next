package com.covid19next.domain.city;

import com.covid19next.domain.BaseTime;
import com.covid19next.domain.country.Country;
import com.covid19next.domain.travel.TravelCourse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class City extends BaseTime {

    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    private Long id;
    private String nameKr;
    private String nameEn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "county_id")
    private Country country;

    @OneToMany(mappedBy = "city")
    private List<TravelCourse> travelCourses = new ArrayList<>();

    @Builder
    public City(String nameKr, String nameEn, Country country) {
        this.nameKr = nameKr;
        this.nameEn = nameEn;
        this.country = country;
    }


}
