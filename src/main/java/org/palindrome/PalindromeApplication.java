package org.palindrome;

import io.vavr.collection.Stream;

public class PalindromeApplication {
    public static void main(String[] args){
        String input = args[0];
        Stream<String> output = new PalindromeDetector(input).findPalindromes();
        String formatted = new Formatter(input).format(output);
        System.out.println(formatted);
    }
}


