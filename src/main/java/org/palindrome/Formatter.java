package org.palindrome;

public class Formatter {
    private final String input;
    
    public Formatter(String input){
        this.input = input;
    }
    
    public String format(String... palindromes){
        return String.format("Text: %s, Index: %d, Length: %d", palindromes[0], input.indexOf(palindromes[0]), palindromes[0].length());
    }
}
