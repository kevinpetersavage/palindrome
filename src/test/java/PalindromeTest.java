import io.vavr.collection.Stream;
import org.junit.Test;

import java.util.Arrays;

import static org.fest.assertions.Assertions.*;

public class PalindromeTest {
    @Test
    public void shouldReturnExpectedOutputFromGivenExample(){
        String input = "sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop";

        Stream<String> output = new PalindromeApplication(input).findPalindromes();

        String expectedOutput =
            "Text: hijkllkjih, Index: 23, Length: 10\n" +
            "Text: defggfed, Index: 13, Length: 8\n" +
            "Text: abccba, Index: 5 Length: 6";
        assertThat(output.asJava()).isEqualTo(Arrays.asList("hijkllkjih", "defggfed", "abccba"));
    }
}
