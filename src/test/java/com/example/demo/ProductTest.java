/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

import com.example.demo.model.ProductModel;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Alexa
 */
public class ProductTest {
    
    private static final List<ProductModel> CATALOG = Arrays.asList(new ProductModel(1, "Samsung S7", "Samsung", 1220),
        new ProductModel(2, "Apple mon cul", "Apple", 5000),
        new ProductModel(3, "Ching-Chong xiaomie", "JSP", 222),
        new ProductModel(2, "Apple mon cul 2 le retour", "Apple", 5001));
    
    
    @Test
    public void shouldPrintUniqBrand(){
        System.out.print("shouldPrintUniqBrand() : ");
        CATALOG.stream().map(ProductModel::getBrand).distinct().forEach(System.out::println);
    }
    
    @Test
    public void shouldPrintAllBrandsUppercaseAsStringJoinByComma(){
        System.out.println("shouldPrintAllBrandsUppercaseAsStringJoinByComma() : " +
                CATALOG.stream()
                .map(ProductModel::getBrand)
                .map(String::toUpperCase)
                .collect(Collectors.joining(","))
        );
    }
    
    @Test
    public void shouldCountNbApple(){
        long total = CATALOG.stream().filter(p -> "Apple".equals(p.getBrand())).count();
        System.out.println("shouldCountNbApple() : " + total);
        assertEquals(2, total);
    }

    @Test
    public void shouldPrintProductsWithPriceAbove1000(){
        System.out.print("shouldPrintProductsWithPriceAbove1000 + ");
        CATALOG.stream().filter(p -> p.getPrice() > 1000).forEach(System.out::println);
    }
    
    @Test
    public void getCheapestProduct(){
        System.out.println("getCheapestProduct() : " + CATALOG.stream().min(Comparator.comparing(ProductModel::getPrice)).get());
    }
    
    @Test
    public void getAveragePrice(){
        System.out.println("getAveragePrice() : " + CATALOG.stream().map(ProductModel::getPrice).mapToDouble(price -> price).average());
    }
    
    @Test
    public void sumPrices(){
        System.out.println("sumPrices() : " + CATALOG.stream().map(ProductModel::getPrice).mapToDouble(price -> price).sum());
    }
    
    @Test
    public void sumPricesWithReduce(){
        System.out.println("sumPricesWithReduce() : " + CATALOG.stream().map(ProductModel::getPrice).reduce(0.0, (total,price) -> total + price));
    }
    
    @Test
    public void getStatistics(){
        System.out.println("getStatistics() : " + CATALOG.stream().map(ProductModel::getPrice).mapToDouble(price -> price).summaryStatistics());
    }
    
    @Test
    public void shouldFindById(){
        ProductModel product = CATALOG.stream().filter(p -> p.getId() == 3).findFirst().orElse(null);
        assertEquals(3, product.getId());
    }
    
    @Test
    public void shouldFindByIdWithForEach(){
        ProductModel product = null;
        for(ProductModel prd : CATALOG){
            if(prd.getId() == 3)
                product = prd;
        }
        assertEquals(3, product.getId());
    }
    
    @Test
    public void shouldSortByBrand(){
        CATALOG.stream()
               .sorted(Comparator.comparing(ProductModel::getBrand)
               .thenComparing(ProductModel::getName))
               .forEach(System.out::println);
        
        //Classe anonyme
        Collections.sort(CATALOG, new Comparator<ProductModel>(){
            @Override
            public int compare(ProductModel p1, ProductModel p2){
                return p1.getBrand().compareTo(p2.getBrand());
            }
        });
    }
}