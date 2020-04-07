package com.galvanize;

import com.galvanize.model.SearchResults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.transform.Result;
import java.util.List;

@RestController
@RequestMapping
public class OMDBController {
    private String apiKey = "&apiKey=e5a1689e";
    private String url = "http://www.omdbapi.com/";
    RestTemplate restTemplate;
    public OMDBController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @GetMapping
    public ResponseEntity<SearchResults> searchResults(@RequestParam String searchQuery){
        String searchUrl = url + "?s=" + searchQuery + apiKey;
        return ResponseEntity.ok(this.restTemplate.getForObject(searchUrl, SearchResults.class));
    }

}
