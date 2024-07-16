package org.elianachv.streams.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Product {
  private String id;
  private String title;
  private Double price;
  private Site site;

  public static List<Product> getProducts(){
    List<Product> products = new ArrayList<>();

    products.add(new Product("MLA123", "Producto1", 4.5, Site.MLA));
    products.add(new Product("MLA122", "Producto2", 7.0, Site.MLA));
    products.add(new Product("MCO123", "Producto3", 10.7, Site.MCO));
    products.add(new Product("MCE123", "Producto4", 50.0, Site.MCE));
    products.add(new Product("MLB321", "Producto5", 1.4, Site.MLB));

    return products;
  }
}

