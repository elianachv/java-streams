package org.elianachv.streams.examples;

import java.util.Optional;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ReduceStream {

  public static void main(String[] args) {


    // Obtener la suma de todos los caracteres en total

    /*
    Identidad: -
    Acumulador: (a, b) -> a + b
    Combinador: -
    */

    Stream<String> countries1 = Stream.of("Argentina", "Colombia", "Peru", "Nicaragua");
    Optional<Integer> total1 = countries1.map(String::length).reduce(Integer::sum);
    System.out.println(total1.get());

    /*
    Identidad: 0
    Acumulador: (a, b) -> a + b
    Combinador: -
    */

    Stream<String> countries2 = Stream.of("Argentina", "Colombia", "Peru", "Nicaragua");
    int total2 = countries2.map(String::length).reduce(0, Integer::sum);
    System.out.println(total2);

    /*
    Identidad: 0
    Acumulador: (a, b) -> a + b
    Combinador: (a, b) -> a + b
    */

    Stream<String> countries3 = Stream.of("Argentina", "Colombia", "Peru", "Nicaragua");
    int total3 = countries3.parallel().reduce(0, (charSum, country)-> charSum + country.length(), (a,b) -> {
      System.out.println("Combinador called");
      return a+b;
    });
    System.out.println(total3);

  }
}