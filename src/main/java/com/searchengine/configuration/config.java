package com.searchengine.configuration;


import com.searchengine.loader.FileLoader;
import com.searchengine.loader.LoaderInt;
import com.searchengine.searcher.Searcher;
import com.searchengine.searcher.SearcherInt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration // current class is only for Spring purpose and will hold beans definitions (annotated with @Bean).
public class config {

    @Bean
    public SearcherInt seacher(LoaderInt loader){
        SearcherInt searcher = new Searcher();
        searcher.indexingDoc(loader);
        return searcher;
    }

    @Bean
    public LoaderInt loader(){
        return new FileLoader();
    }

}
