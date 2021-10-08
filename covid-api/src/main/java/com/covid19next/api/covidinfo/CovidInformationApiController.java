package com.covid19next.api.covidinfo;

import com.covid19next.domain.Result;
import com.covid19next.domain.covidinfo.CovidInformation;
import com.covid19next.domain.covidinfo.CovidInformationResponse;
import com.covid19next.service.covidinfo.CovidInformationService;
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

import java.util.List;

//@CustomBaseApiControllerAnnotation
@CustomPublicApiControllerAnnotation
@RestController
@RequiredArgsConstructor
public class CovidInformationApiController {

    private final CovidInformationService covidInformationService;

    @GetMapping("/covid-information")
    public Page<CovidInformationResponse> getAllCovidInformation(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        PageRequest request = PageRequest.of(page, size, Sort.Direction.DESC, "wrtDt");
        return covidInformationService.findAll(request);
    }

    @GetMapping("/covid-information/{id}")
    public ResponseEntity<CovidInformation> getCovidInformation(@PathVariable String id) {
        CovidInformation byId = covidInformationService.findById(id);
        return ResponseEntity.ok(byId);
    }


    @GetMapping("/covid-information/search")
    public ResponseEntity<Result<List<CovidInformationResponse>>> getCovidInformationByKeyword(@RequestParam("keyword") String keyword) {
        List<CovidInformationResponse> covidInformationResponses = covidInformationService.findAllByKeyword(keyword);
        return ResponseEntity.ok(new Result<>(covidInformationResponses.size(), covidInformationResponses));
    }


}
