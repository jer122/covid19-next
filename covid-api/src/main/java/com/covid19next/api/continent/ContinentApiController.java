package com.covid19next.api.continent;

import com.covid19next.domain.continent.Continent;
import com.covid19next.domain.continent.ContinentClientResponse;
import com.covid19next.service.continent.ContinentService;
import com.covid19next.util.CustomPublicApiControllerAnnotation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CustomPublicApiControllerAnnotation
@RequiredArgsConstructor
public class ContinentApiController {

    private final ContinentService continentService;

    @GetMapping("/continents")
    public List<ContinentClientResponse> getContinents() {
        return continentService.findAll();
    }


}
