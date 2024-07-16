package org.elianachv.streams.examples;

import org.elianachv.streams.models.Product;
import org.elianachv.streams.models.Site;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IntermediateOperations {

  public static void main(String[] args) {

    List<Product> products = Product.getProducts();

    filter(products);
    sort(products);
    map(products);

  }

  private static void filterWithoutStreams(List<Product> products) {

    List<Product> filteredProducts = new ArrayList<>();

   for (Product product : products) {
     if (product.getSite().equals(Site.MLA)) {
       filteredProducts.add(product);
     }
   }

    System.out.println("MLA Products");
    filteredProducts.forEach(p -> System.out.println(p.toString()));

  }

  private static void filter(List<Product> products) {
    List<Product> filteredProductsBySite = products.stream()
            .filter(p -> p.getSite().equals(Site.MLA))
            .toList();

    System.out.println("MLA Products");
    filteredProductsBySite.forEach(p -> System.out.println(p.toString()));

    List<Product> filteredProductsByPrice = products.stream()
            .filter(p -> p.getPrice() > 9.0)
            .toList();

    System.out.println("Products more expensive than 9.0");
    filteredProductsByPrice.forEach(p -> System.out.println(p.toString()));
  }

  private static void sort(List<Product> products) {
    List<Product> sortedProductsByTittle = products.stream()
            .sorted(Comparator.comparing(Product::getTitle))
            .toList();

    System.out.println("Products sorted by title");
    sortedProductsByTittle.forEach(p -> System.out.println(p.getTitle()));

    List<Product> sortedProductsByPrice = products.stream()
            .sorted(Comparator.comparing(Product::getPrice).reversed())
            .toList();

    System.out.println("Products sorted by price (DESC)");
    sortedProductsByPrice.forEach(p -> System.out.println(p.getPrice()));

  }

  private static void map(List<Product> products) {
    List<Double> mapPricesPlusTax = products.stream()
            .map(p -> p.getPrice() + 10)
            .toList();

    System.out.println("Prices + Tax");
    mapPricesPlusTax.forEach(System.out::println);

  }




}
