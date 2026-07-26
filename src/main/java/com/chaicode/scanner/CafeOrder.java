package com.chaicode.scanner;

import java.util.Scanner;

/**
 * BeanStreet Cafe Order Terminal
 *
 * <p>Read line items from a Scanner until a line "DONE" is entered. Each line before DONE
 * is a price (double). Return the order total.
 *
 * <p>Example input:
 * <pre>
 * 4.50
 * 3.25
 * 2.00
 * DONE
 * </pre>
 * Total = 9.75
 *
 * <p>Rules:
 * <ul>
 *   <li>Skip blank lines</li>  
 *   <li>Ignore negative prices</li>
 *   <li>If scanner is null, return 0.0</li>
 * </ul>
 *
 * @param scanner input source
 * @return order total
 */

public class CafeOrder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter prices one by one. Type DONE when finished:");

        double total = readOrderTotal(sc);

        System.out.println("Order Total: " + String.format("%.2f", total));

        sc.close();
    }

    public static double readOrderTotal(Scanner scanner) {

        if (scanner == null) {
            return 0.0;
        }

        double total = 0.0;

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine().trim();

            if (line.equals("DONE") || line.equals( "done")) {
                break;
            }

            if (line.isEmpty()) {
                continue;
            }

            double price = Double.parseDouble(line);

            if (price < 0) {
                continue;
            }

            total = total + price;
        }

        return total;
    }
}