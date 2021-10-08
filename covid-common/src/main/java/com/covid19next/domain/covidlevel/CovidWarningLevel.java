package com.covid19next.domain.covidlevel;


import com.covid19next.domain.BaseTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "covid_warning_level")
public class CovidWarningLevel extends BaseTime {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long level;

  @Column(name = "level_name")
  private String levelName;

  @Nullable
  @Column(name = "country_id")
  private Long countryId;

  private String country;

  @Builder
  public CovidWarningLevel(Long level, String levelName, Long countryId, String country) {
    this.level = level;
    this.levelName = levelName;
    this.countryId = countryId;
    this.country = country;
  }
}
