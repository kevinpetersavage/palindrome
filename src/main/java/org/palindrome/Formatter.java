package org.palindrome;

import java.util.stream.Collectors;

import io.vavr.collection.Stream;

public class Formatter {
    private final String input;
    
    public Formatter(String input){
        this.input = input;
    }
    
    public String format(Stream<String> palindromes){
        return palindromes.map(palindrome -> 
                String.format("Text: %s, Index: %d, Length: %d", 
                    palindrome, 
                    input.indexOf(palindrome), 
                    palindrome.length()
                )
            ).collect(Collectors.joining("\n"));
    }
}
