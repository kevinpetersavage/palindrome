package org.palindrome;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.Stream;

public class PalindromeDetector {
    private final String input;

    public PalindromeDetector(String input) {
        this.input = input;
    }

    public Stream<String> findPalindromes() {
        return Stream
                .range(0, this.input.length() - 1)
                .map(x -> this.input.length() - x)
                .flatMap(this::possibleRanges)
                .map(tuple -> input.substring(tuple._1, tuple._2))
                .filter(substring -> substring.equals(new StringBuilder(substring).reverse().toString()))
                .distinctBy((string1,string2) -> string2.contains(string1) ? 0 : 1)
                .take(3);
    }

    private Stream<Tuple2<Integer, Integer>> possibleRanges(int rangeLength) {
        return Stream
            .range(0, this.input.length() - rangeLength)
            .map(i -> Tuple.of(i, i + rangeLength + 1));
    }
}


