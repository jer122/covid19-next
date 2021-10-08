package com.covid19next.repository.covid.restriction;

import com.covid19next.domain.covid.restriction.CovidCountryRestriction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CovidCountryRestrictionRepository extends JpaRepository<CovidCountryRestriction, String>, CustomCovidCountryRestrictionRepository {
    Optional<CovidCountryRestriction> findByCode(String code);
}
