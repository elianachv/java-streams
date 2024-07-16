package org.elianachv.streams.examples;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStreams {

  public static void main(String[] args) {

    // IntStream
    IntStream intStream = IntStream.range(1, 3);

    // LongStream
    LongStream longStream = LongStream.rangeClosed(1, 3);

    // DoubleStream
    Random random = new Random();
    DoubleStream doubleStream = random.doubles(3);

    // range endExclusive rangeClosed endInclusive

    intStream.close();
    longStream.close();
    doubleStream.close();
  }
}