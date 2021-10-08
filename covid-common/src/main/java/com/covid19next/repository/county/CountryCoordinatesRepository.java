package com.covid19next.repository.county;


import com.covid19next.domain.country.CountryCoordinates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryCoordinatesRepository extends JpaRepository<CountryCoordinates, Long> {
}
