package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] prices = Arrays.stream(reader.readLine().split(",\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        UnaryOperator<Double> addVat = value -> value * 1.2;

        System.out.println("Prices with VAT:");
        for (double price : prices) {
            double priceWithVAT = addVat.apply(price);
            System.out.printf("%.2f%n", priceWithVAT);
        }
    }
}
