package org.elianachv.streams.examples;

import org.elianachv.streams.models.Product;
import org.elianachv.streams.models.Site;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Exercises {

  public static void main(String[] args) {

    List<Product> products = Product.getProducts();
    exercise1(products);

  }

  private static void exercise1(List<Product> products) {

    // Obtener el producto más caro del site de Argentina

    Optional<Product> product = products.stream()
            .filter(p -> p.getSite().equals(Site.MLA))
            .max(Comparator.comparing(Product::getPrice));

    product.ifPresentOrElse(
            p -> System.out.println("The most expensive product from MLA is " + p),
            () -> System.out.println("There aren't any MLA products "));

  }

  private static void exercise2(List<Product> products) {

    // Obtener cuantos productos hay del site de Colombia

    long totalColombiaProducts = products.stream()
            .filter(p -> p.getSite().equals(Site.MCO))
            .count();

    System.out.println("There are " + totalColombiaProducts + " products in MCO site");

  }

  private static void exercise3(List<Product> products) {

    // Obtener cuantos caracteres suman los títulos de todos los productos

    int totalChars = products.stream()
            .mapToInt(product -> product.getTitle().length())
            .sum();

    System.out.println("The total chars of all products titles is " + totalChars);

  }


}
