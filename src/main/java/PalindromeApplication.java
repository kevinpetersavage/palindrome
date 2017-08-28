import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.Stream;

import java.util.Arrays;

public class PalindromeApplication {
    private final String input;

    public void main(String[] args) {
        String input = Arrays.stream(args).reduce((x, y) -> x + y).orElse("");
        System.out.println(new PalindromeApplication(input).findPalindromes());
    }

    public PalindromeApplication(String input) {
        this.input = input;
    }

    public Stream<String> findPalindromes() {
        return Stream
                .range(0, input.length())
                .map(x -> input.length() - x)
                .flatMap(this::possibleRanges)
                .map(tuple -> input.substring(tuple._1, tuple._2))
                .filter(substring -> substring.equals(new StringBuilder(substring).reverse().toString()))
                .distinctBy((string1,string2) -> string2.contains(string1) ? 0 : 1)
                .take(3);
    }

    private Stream<Tuple2<Integer, Integer>> possibleRanges(int rangeLength) {
        return Stream.range(0, input.length() - rangeLength).map(i -> Tuple.of(i, i + rangeLength));
    }
}


