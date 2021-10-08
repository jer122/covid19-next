package com.covid19next.api.city;

import com.covid19next.domain.city.CityRequest;
import com.covid19next.domain.city.CityResponse;
import com.covid19next.service.city.CityService;
import com.covid19next.util.CustomBaseApiControllerAnnotation;
import com.covid19next.util.CustomPublicApiControllerAnnotation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CustomBaseApiControllerAnnotation
@CustomPublicApiControllerAnnotation
@RequiredArgsConstructor
public class CityApiController {
    private final CityService cityService;

    @GetMapping("/cities/{name}")
    public List<CityResponse> getCities(@PathVariable String name) {
        return cityService.getCities(name);
    }

    @GetMapping("/cities")
    public List<CityResponse> getCity() {
        return cityService.findAll();
    }

    @PostMapping("/city")
    public Long saveCity(@RequestBody CityRequest cityRequest) {
        return cityService.saveCity(cityRequest);
    }
}
