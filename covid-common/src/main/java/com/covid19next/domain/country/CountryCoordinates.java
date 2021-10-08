package com.covid19next.domain.country;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class CountryCoordinates {

    @Id
    @Column(name = "coordinate_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long latitude;
    private Long longitude;



    @Builder
    public CountryCoordinates(Long id, Long latitude, Long longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
