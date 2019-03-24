package com.searchengine.controller;


import com.searchengine.searcher.SearcherInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // it's a convenience annotation that combines @Controller and @ResponseBody – which eliminates the need to annotate every request handling method of the controller class with the @ResponseBody annotation.
public class controller {
    private final SearcherInt searcher;

    @Autowired //annotation allows Spring to resolve and inject collaborating beans into bean
    public controller(SearcherInt searcher){
        this.searcher = searcher;
    }

    @RequestMapping(value = "/word ={equals}",method = RequestMethod.GET, produces = "application/json")
    public List<String> getJSON(@PathVariable String equals) {
        return searcher.seacher(equals);
    }




}
