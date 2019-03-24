package com.searchengine.searcher;

import com.searchengine.loader.LoaderInt;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class Searcher implements SearcherInt {

    private long numberofIndexedFiles;
    /**
     *  map of inverted store data
     */
    private Map<String, Map<String,Double>> tf = new HashMap<>();
    private Map<String, List<TfIdf>> tfidf = new HashMap<>();

    @Data
    private class TfIdf{
        private String name;
        private double tfidfWeight;
    }



    @Override
    public void indexingDoc(LoaderInt path) {
        numberofIndexedFiles = path.getAmountOfFiles();
        path.getFiles().forEach(a -> addDocToIndex(a.getFileName(), a.getContent()));
        createIndex();
    }
    @Override
    public List<String> seacher(String value) {
        List<TfIdf> tfIdfs = tfidf.getOrDefault(value, Collections.emptyList());
        return tfIdfs.stream().filter(a -> a.getTfidfWeight() > 0).map(TfIdf::getName).collect(Collectors.toList());
    }

    /**
     * adds files to index
     *
     */
    private void addDocToIndex(String name, String content){
        List<String> tokens = Arrays.asList(content.split("\\W+"));

        Set<String> toProcess = new HashSet<>(tokens);

        toProcess.forEach(value -> {
            List<TfIdf> s = tfidf.computeIfAbsent(value, key -> new LinkedList<>());
            TfIdf e = new TfIdf();
            e.setName(name);
            s.add(e);
        });

        tfidf.keySet().forEach(value -> {
            double valueF = (double) Collections.frequency(tokens, value) / tokens.size();
            Map<String, Double> map = tf.computeIfAbsent(value, key -> new HashMap<>());
            map.put(name, valueF);
        });
        log.info("Document: {}",name);
    }

    /**
     * putting index into all loaded files
     */
    private void createIndex(){
        tf.forEach((value, valueFreqEaFile)->{
            double idf = Math.log((double)numberofIndexedFiles / tfidf.get(value).size());

                valueFreqEaFile.forEach((fileName, valueFreq)->{
                    double tfidfValue = valueFreq * idf;
                    log.debug("tf-idf file {} value {} tf-idf {}",fileName,value,tfidfValue);

                    List<TfIdf> tfidfWeights = tfidf.get(value);

                    tfidfWeights.stream().filter(e -> fileName.equals(e.getName())).forEach(e -> e.setTfidfWeight(tfidfValue));
                });

                tfidf.get(value).sort(Comparator.comparing(TfIdf::getTfidfWeight).reversed()); // sorting loaded content
        });

    }
}
