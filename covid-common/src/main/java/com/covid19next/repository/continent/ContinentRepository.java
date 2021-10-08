package com.covid19next.repository.continent;

import com.covid19next.domain.continent.Continent;
import com.covid19next.domain.country.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, Long> {
}
