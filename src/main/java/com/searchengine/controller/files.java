package com.searchengine.controller;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * both of those annotation comes out of lombok tool
 */
@Data //is a convenient shortcut annotation that bundles the features of @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together
@AllArgsConstructor //generates a constructor with 1 parameter for each field in class
public class files {
    private String fileName;
    private String content;
}
