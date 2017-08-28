package org.palindrome;

import java.util.Arrays;

public class PalindromeApplication {
    public void main(String[] args) {
        String input = Arrays.stream(args).reduce((x, y) -> x + y).orElse("");
        System.out.println(new PalindromeDetector(input).findPalindromes());
    }
}


