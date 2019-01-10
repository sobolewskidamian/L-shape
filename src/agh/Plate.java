package agh;

import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public class Plate {
    private int size;
    private double[][] temp;
    private double tempBrzegowa;

    public Plate(int size, double tempBrzegowa) {
        this.size = size;
        this.temp = new double[size][size];
        this.tempBrzegowa = tempBrzegowa;
        //this.temp[3][3]=2.7;
    }

    public void init(double[][] a) {
        temp = a;
    }

    public void print() {
        AnsiConsole.systemInstall();
        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < size + 2; j++) {
                if ((j == 0 && i <= size / 2 + 1) || j == size + 1 || i == 0 || j==0) {
                    System.out.print("\t");
                    continue;
                }
                if (i <= size / 2 + 1 || (i > size / 2 && j > (size-1) / 2))
                    System.out.print(temp[i - 1][j - 1]+ "\t");
                else
                    System.out.print("\t");
            }
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }
        for (int i = 0; i < (size+1) / 2; i++)
            System.out.print("\t");
    }
}
