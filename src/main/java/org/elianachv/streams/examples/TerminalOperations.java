package org.elianachv.streams.examples;

import org.elianachv.streams.models.Product;
import org.elianachv.streams.models.Site;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperations {

  public static void main(String[] args) {

    List<Product> products = Product.getProducts();

    min(products);
    max(products);
    allMatch(products);
    anyMatch(products);
    group(products);

  }

  private static void max(List<Product> products) {
    Optional<Product> moreExpensiveProduct = products.stream()
            .max(Comparator.comparing(Product::getPrice));

    System.out.println("Which is the most expensive products? " + moreExpensiveProduct.get());

  }

  private static void min(List<Product> products) {
    Optional<Product> lessExpensiveProduct = products.stream()
            .min(Comparator.comparing(Product::getPrice));

    System.out.println("Which is the less expensive products? " + lessExpensiveProduct.get());

  }

  private static void allMatch(List<Product> products) {
    boolean allProductsAreFromMLA = products.stream()
            .allMatch(p -> p.getSite().equals(Site.MLA));

    System.out.println("All products are from MLA site? " + allProductsAreFromMLA);

  }

  private static void anyMatch(List<Product> products) {

    boolean atLeastOneProductIsFromMLB = products.stream()
            .anyMatch(p -> p.getSite().equals(Site.MLB));

    System.out.println("At least one product is from MLB site? " + atLeastOneProductIsFromMLB);

  }

  private static void group(List<Product> products) {

    Map<Site,List<Product>> productsBySite = products.stream()
            .collect(Collectors.groupingBy(Product::getSite));

    productsBySite.forEach((site, productsList) -> {
      System.out.println(site);
      productsList.forEach(System.out::println);
    });

  }




}
