package com.searchengine.controller;


import com.searchengine.searcher.SearcherInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // it's a convenience annotation that combines @Controller and @ResponseBody – which eliminates the need to annotate every request handling method of the controller class with the @ResponseBody annotation.
public class Controller {
    private final SearcherInt searcher;

    @Autowired //annotation allows Spring to resolve and inject collaborating beans into bean
    public Controller(SearcherInt searcher) {
        this.searcher = searcher;
    }

    @GetMapping
    public List<String> getJSON(String word) {
        return searcher.seacher(word);


    }
}
