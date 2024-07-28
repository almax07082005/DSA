package tinkoff.fintech;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();
        if (n == 1) System.out.println(1);
        else System.out.println(4L * (n - 1));

        scanner.close();
    }
}
