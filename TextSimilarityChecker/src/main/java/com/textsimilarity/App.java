package com.textsimilarity;

import com.textsimilarity.service.SimilarityChecker;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Text Similarity Checker ===");
        System.out.print("Enter first text: ");
        String text1 = sc.nextLine();

        System.out.print("Enter second text: ");
        String text2 = sc.nextLine();

        SimilarityChecker checker = new SimilarityChecker();
        double similarity = checker.computeSimilarity(text1, text2);

        System.out.printf("Similarity Score: %.2f%%\n", similarity * 100);
    }
}
