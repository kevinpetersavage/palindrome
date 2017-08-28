package org.palindrome;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

public class FormatterTest {
    @Test
    public void shouldFormatOneLine(){
        Formatter formatter = new Formatter("sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop");
        
        assertThat(formatter.format("hijkllkjih"))
            .isEqualTo("Text: hijkllkjih, Index: 23, Length: 10");
    }

    @Test
    public void shouldFormatNoLines(){
        
    }

    @Test
    public void shouldFormatMultipleLines(){
        
    }
}
