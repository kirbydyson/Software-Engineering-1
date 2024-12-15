package org.example;

import java.io.*;
import java.util.*;

public class ShoppingCartDemonstrationTest {
    public static void main(String[] args) throws IOException {
        List<Product> products = readProducts("shoppingCart.csv");
        ShoppingCart myCart = new ShoppingCart(products);
        Map<Product, Double> reductions = readReductions("reductions.csv");

        double total = myCart.calculateTotal(reductions, 7.5);
        System.out.printf("Total paid: %.2f%n", total);

        System.out.println("\n***REDUCTION MAP***");
        reductions.entrySet().forEach(entry -> System.out.println(entry.getKey().name + " reduced by: " + entry.getValue()));

        Set<Product> sales = myCart.searchSaleItems(reductions.keySet());
        System.out.println("\n***SALE ITEMS***");
        sales.forEach(item -> System.out.println(item.getName()));

        System.out.println("\n***ASCENDING ORDER**");
        Collections.sort(products, ProductComparator.ASCENDING);
        products.forEach(item -> System.out.println(item.getName()));

        System.out.println("\n***DESCENDING ORDER***");
        Collections.sort(products, ProductComparator.DESCENDING);
        products.forEach(item -> System.out.println(item.getName()));
    }

    enum ProductComparator implements Comparator<Product> {
        ASCENDING {
            @Override
            public int compare(Product p1, Product p2) {
                return Comparator.comparing(Product::getName).compare(p1, p2);
            }
        },
        DESCENDING {
            @Override
            public int compare(Product p1, Product p2) {
                return Comparator.comparing(Product::getName).reversed().compare(p1, p2);
            }
        }
    }
    private static List<Product> readProducts(String path) throws FileNotFoundException {
        List<Product> products = new ArrayList<>();
        Scanner scanner = new Scanner(new File(path));
        while(scanner.hasNextLine()){
            String info = scanner.nextLine();
            String[] columns = info.split(",");
            int id = Integer.parseInt(columns[0]);
            double price = Double.parseDouble(columns[1]);
            String name = columns[2];
            products.add(new Product(id, price, name));
        }
        return products;
    }
    private static Map<Product, Double> readReductions(String path) throws IOException {
        Map<Product, Double> reductions = new HashMap<>();
        BufferedReader buffer = new BufferedReader(new FileReader(path));
        String line;
        while((line = buffer.readLine()) != null){
            String[] columns = line.split(",");
            int id = Integer.parseInt(columns[0]);
            double price = Double.parseDouble(columns[1]);
            String name = columns[2];
            double reduction = Double.parseDouble(columns[3]);
            if(reduction >= 0 && reduction <= 100){
                Product product = new Product(id, price, name);
                reductions.put(product, reduction);
            }
        }
        buffer.close();
        return reductions;
    }
}
