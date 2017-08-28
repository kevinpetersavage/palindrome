package org.palindrome;

import io.vavr.collection.Stream;
import org.junit.Test;

import java.util.Arrays;

import static org.fest.assertions.Assertions.*;

public class PalindromeDetectorTest {
    @Test
    public void shouldReturnExpectedOutputFromGivenExample(){
        check("sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop", "hijkllkjih", "defggfed", "abccba");
    }
    
    @Test
    public void shouldDetectSinglePaleindrome(){
        check("hannah", "hannah");     
    }
    
    @Test(timeout=100)
    /**
     * timout because this should be the worst case of the algorithm
     */
    public void shouldDetectNoPalindromes(){
        check("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");             
    }

    @Test
    public void shouldDetectNoPalindromesFromEmptyString(){
        check("");     
    }
    
    private void check(String input, String... expectedOuput){
        Stream<String> output = new PalindromeDetector(input).findPalindromes();
        assertThat(output.asJava()).isEqualTo(Arrays.asList(expectedOuput));   
    }
}
