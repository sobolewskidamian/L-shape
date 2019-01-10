package agh;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rozmiar: ");
        int rozmiar = scanner.nextInt();
        System.out.print("G: ");
        double g = scanner.nextDouble();
        System.out.print("Temperatura brzegowa: ");
        double brzeg = scanner.nextDouble();

        if (rozmiar > 0)
            new lshape(rozmiar, g, brzeg).solve();
        else
            System.out.println("Rozmiar >= 0");
    }
}
