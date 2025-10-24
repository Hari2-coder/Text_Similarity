package com.textsimilarity.service;

import com.textsimilarity.utils.TextPreprocessor;
import java.util.*;

public class SimilarityChecker {

  private final TextPreprocessor preprocessor = new TextPreprocessor();

  public double computeSimilarity(String text1, String text2) {
    List<String> tokens1 = preprocessor.tokenize(text1);
    List<String> tokens2 = preprocessor.tokenize(text2);

    Map<String, Integer> freq1 = preprocessor.termFrequency(tokens1);
    Map<String, Integer> freq2 = preprocessor.termFrequency(tokens2);

    Set<String> allWords = new HashSet<>();
    allWords.addAll(freq1.keySet());
    allWords.addAll(freq2.keySet());

    double dotProduct = 0.0;
    double mag1 = 0.0;
    double mag2 = 0.0;

    for (String word : allWords) {
      int x = freq1.getOrDefault(word, 0);
      int y = freq2.getOrDefault(word, 0);
      dotProduct += x * y;
      mag1 += Math.pow(x, 2);
      mag2 += Math.pow(y, 2);
    }

    return (mag1 == 0 || mag2 == 0) ? 0.0 : dotProduct / (Math.sqrt(mag1) * Math.sqrt(mag2));
  }
}
