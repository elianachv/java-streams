package org.elianachv.streams.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Creation {

  public static void main(String[] args) {

    // 1. Empty Stream
    Stream<String> emptyStream = Stream.empty();

    // 2. Stream of
    Stream<String> streamOf = Stream.of("a", "b", "c");

    // 3. Using builder
    Stream<String> builderStream = Stream.<String>builder()
            .add("a")
            .add("b")
            .add("c")
            .build();

    // 4. Based on an array
    String[] strings = { "a", "b", "c" };
    Stream<String> arrayStream = Arrays.stream(strings);

    // 5. Based on a collection (List, Set, ect)
    List<String> list = Arrays.asList(strings);
    Stream<String> collectionStream = list.stream();

    // 6. Using generate
    // In this case limit must be used to avoid infinite stream
    Stream<String> generatedStream = Stream.generate(() -> "element").limit(10);


    emptyStream.close();
    streamOf.close();
    builderStream.close();
    arrayStream.close();
    collectionStream.close();
    generatedStream.close();

  }
}