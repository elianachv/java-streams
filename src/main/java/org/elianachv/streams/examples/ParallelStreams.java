package org.elianachv.streams.examples;

import org.elianachv.streams.models.Product;
import org.elianachv.streams.models.Site;

import javax.sound.midi.Soundbank;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreams {

  static int TOTAL;

  public static void main(String[] args) {

    // Analyzing Threads
    int availableProcessors = Runtime.getRuntime().availableProcessors();
    System.out.println("Available Processors: " + availableProcessors);
    System.out.println("Seq flow");
    printStream(IntStream.rangeClosed(1, 10), false);
    printStream(IntStream.rangeClosed(1, 10).parallel(), true);

    // Test interacting with Data
    List<Product> products = Product.getProducts();
    manipulatingData(products.stream(), false);
    manipulatingData(products.stream().parallel(), true);

    // Test updating data
    updatingVariable(IntStream.rangeClosed(1, 1000), false);
    updatingVariable(IntStream.rangeClosed(1, 1000).parallel(), true);

  }

  static void printStream(IntStream stream, boolean parallel) {
    System.out.println("PRINTING STREAM");
    System.out.println(parallel ? "Parallel Test" : "Sequential Test");
    long start = System.currentTimeMillis();
    stream.forEach(n -> {
      System.out.println(LocalTime.now() + " Value: " + n + " Thread: " + Thread.currentThread().getName());
      try {
        Thread.sleep(200);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
    long end = System.currentTimeMillis();
    System.out.println("Time: " + (end - start) + " ms");
    memory();
    System.out.println("=====================");
  }

  static void manipulatingData(Stream<Product> products, boolean parallel) {
    System.out.println("MANIPULATING DATA");
    System.out.println(parallel ? "Parallel Test" : "Sequential Test");
    long start = System.currentTimeMillis();
    double sum = products
            .mapToDouble(product -> product.getPrice())
            .sum();

    System.out.println("Total: " + sum);
    long end = System.currentTimeMillis();
    System.out.println("Time: " + (end - start) + " ms");
    memory();
    System.out.println("=====================");

  }

  static void updatingVariable(IntStream numbers, boolean parallel) {
    System.out.println("UPDATING VARIABLE");
    System.out.println(parallel ? "Parallel Test" : "Sequential Test");
    long start = System.currentTimeMillis();
    numbers.forEach(num -> TOTAL += num);
    System.out.println("Result = " + TOTAL);
    long end = System.currentTimeMillis();
    System.out.println("Time: " + (end - start) + " ms");
    memory();
    System.out.println("=====================");

  }

  static void memory() {
    Runtime runtime = Runtime.getRuntime();
    long memory = runtime.totalMemory() - runtime.freeMemory();
    System.out.println("Used memory is bytes: " + (memory / (1024L * 1024L)) + "MB");
  }


}