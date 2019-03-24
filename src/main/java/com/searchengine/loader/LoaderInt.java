package com.searchengine.loader;

import com.searchengine.controller.files;

import java.util.stream.Stream;

public interface LoaderInt {

    /**
     *  amount of files that are avaible to load
     *
     */
    long getAmountOfFiles();

    /**
     * method that gonna read the content and converts it
     * into streams of files that gives scratch of file
     * that includes all the content
     * @return 'stream' of files
     */
    Stream<files> getFiles();

}
