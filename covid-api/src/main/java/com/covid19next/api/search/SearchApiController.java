package com.covid19next.api.search;

import com.covid19next.domain.search.SearchResponse;
import com.covid19next.service.search.SearchService;
import com.covid19next.util.CustomPublicApiControllerAnnotation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CustomPublicApiControllerAnnotation
@RestController
@RequiredArgsConstructor
public class SearchApiController {

    private final SearchService searchService;

    @GetMapping("/search/all")
    public ResponseEntity<SearchResponse> getSearchAll(@RequestParam("keyword") String keyword) {
        return ResponseEntity.ok(searchService.findAllByKeyword(keyword));
    }
}
