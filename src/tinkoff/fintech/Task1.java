package tinkoff.fintech;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();
        final long first_number = 100L;

        System.out.println((first_number + n) / 2 * (n - first_number + 1));
        scanner.close();
    }
}
