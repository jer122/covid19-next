package com.covid19next.service.country;

import com.covid19next.repository.county.CountryCoordinatesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CountryCoordinatesService {

    private final CountryCoordinatesRepository countryCoordinatesRepository;


}
