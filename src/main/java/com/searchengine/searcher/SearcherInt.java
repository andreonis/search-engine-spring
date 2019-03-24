package com.searchengine.searcher;

import com.searchengine.loader.LoaderInt;

import java.util.List;


public interface SearcherInt {
    /** Looking over the data
     *  in order to find value
     *  that we provide
     */
    List<String> seacher(String value);

    /**
     *  indexing files from given path
     * @param path of files
     */
    void indexingDoc(LoaderInt path);

}
