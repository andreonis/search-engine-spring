package com.searchengine.loader;

import com.searchengine.controller.files;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Slf4j
public class FileLoader implements LoaderInt {

    @Value("${files.path}")
    private String filesPath;

    @Override
    public long getAmountOfFiles() {
        try{
            return Files.list(Paths.get(filesPath)).count();
        } catch (IOException e){
            log.error("Cannot access directory {}", filesPath);
            return 0;
        }
    }

    @Override
    public Stream<files> getFiles() {
        try{
            return Files.list(Paths.get(filesPath))
                    .filter(Files::isRegularFile)
                    .map(path -> {
                        String fileName = path.getFileName().toString();
                        String content = "";
                            try{
                                content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
                            } catch (IOException e){
                                log.error("Cannot read files {}", fileName);
                            }
                            return new files(fileName, content);
                    });
        } catch (IOException e){
            log.error("Cannot access directory {}", filesPath);
            return Stream.empty();
        }

    }

}
