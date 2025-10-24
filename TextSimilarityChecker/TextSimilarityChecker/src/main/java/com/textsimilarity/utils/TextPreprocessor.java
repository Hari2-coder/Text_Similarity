package com.textsimilarity.utils;

import java.util.*;
import java.util.stream.Collectors;

public class TextPreprocessor {

    public List<String> tokenize(String text) {
        if (text == null || text.isEmpty()) return Collections.emptyList();

        // Convert to lowercase, remove punctuation, split by spaces
        return Arrays.stream(text.toLowerCase()
                .replaceAll("[^a-z0-9\\s]", "")
                .split("\\s+"))
                .filter(token -> !token.isEmpty())
                .collect(Collectors.toList());
    }

    public Map<String, Integer> termFrequency(List<String> tokens) {
        Map<String, Integer> freq = new HashMap<>();
        for (String token : tokens) {
            freq.put(token, freq.getOrDefault(token, 0) + 1);
        }
        return freq;
    }
}
