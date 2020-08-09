package lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shopsWithProducts = new TreeMap<>();
        String[] productInfo = scanner.nextLine().split(",\\s+");
        while (!productInfo[0].equalsIgnoreCase("revision")) {
            String store = productInfo[0];
            String product = productInfo[1];
            double price = Double.parseDouble(productInfo[2]);
            shopsWithProducts.putIfAbsent(store, new LinkedHashMap<>());
            shopsWithProducts.get(store).put(product, price);

            productInfo = scanner.nextLine().split(",\\s+");
        }

        for (var store : shopsWithProducts.entrySet()) {
            System.out.println(store.getKey() + "->");
            for (var product : store.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", product.getKey(), product.getValue());
            }
        }
    }
}
