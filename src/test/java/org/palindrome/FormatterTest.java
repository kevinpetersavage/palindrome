package org.palindrome;

import static org.fest.assertions.Assertions.*;
import org.junit.Test;
import io.vavr.collection.Stream;

public class FormatterTest {
    @Test
    public void shouldFormatOneLine(){
        Formatter formatter = new Formatter("sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop");
        
        assertThat(formatter.format(Stream.of("hijkllkjih")))
            .isEqualTo("Text: hijkllkjih, Index: 23, Length: 10");
    }

    @Test
    public void shouldFormatNoLines(){
        Formatter formatter = new Formatter("sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop");
        
        assertThat(formatter.format(Stream.empty()))
            .isEqualTo("");
        
    }

    @Test
    public void shouldFormatMultipleLines(){
        Formatter formatter = new Formatter("sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop");
        
        assertThat(formatter.format(Stream.of("hijkllkjih","defggfed","abccba")))
            .isEqualTo(
                "Text: hijkllkjih, Index: 23, Length: 10\n" + 
                "Text: defggfed, Index: 13, Length: 8\n" + 
                "Text: abccba, Index: 5, Length: 6" // this was different in the text but presume wrong?
            );               
    }
}
