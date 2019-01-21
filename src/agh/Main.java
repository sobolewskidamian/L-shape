package agh;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ilosc punktow pomiedzy wezlami: ");
        int amount = scanner.nextInt();
        System.out.print("g = r*");
        double g = scanner.nextDouble();

        if (amount >= 0)
            new Lshape(amount * 2 + 3, g).solve();
        else
            System.out.println("Ilosc punktow >= 0");
    }
}
