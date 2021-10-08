package com.covid19next.api.county;

import com.covid19next.domain.country.Country;
import com.covid19next.domain.country.CountryResponse;
import com.covid19next.repository.county.CountryRepository;
import com.covid19next.service.country.CountryService;
import com.covid19next.util.CustomBaseApiControllerAnnotation;
import com.covid19next.util.CustomPublicApiControllerAnnotation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CustomPublicApiControllerAnnotation
public class CountryApiController {

    private final CountryService countryService;

    @GetMapping("/countries")
    public Page<CountryResponse> getCountries(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        PageRequest request = PageRequest.of(page, size, Sort.by("id"));
        return countryService.findCountries(request);
    }

    @GetMapping("/countries/{code}")
    public ResponseEntity<CountryResponse> getCountry(@PathVariable String code) {
        return ResponseEntity.ok(countryService.findByCode(code));
    }


}
