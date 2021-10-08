package com.covid19next.repository.covid.restriction;

import com.covid19next.domain.covid.restriction.RestrictionDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestrictionDescriptionRepository extends JpaRepository<RestrictionDescription, Long> {
    Optional<List<RestrictionDescription>> findByCovidCountryRestriction_Code(String code);
}
