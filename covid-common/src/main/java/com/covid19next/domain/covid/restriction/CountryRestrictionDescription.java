package com.covid19next.domain.covid.restriction;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CountryRestrictionDescription {

    private String code;
    private String countryName;
    private RestrictionType restrictionType;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public CountryRestrictionDescription(String code, String countryName, RestrictionType restrictionType, String description) {
        this.code = code;
        this.countryName = countryName;
        this.restrictionType = restrictionType;
        this.description = description;
    }
}
