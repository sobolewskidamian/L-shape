package agh;

import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public class Plate {
    private int size;
    private Double[][] temp;
    private double tempBrzegowa;

    public Plate(int size, double tempBrzegowa) {
        this.size = size;
        this.temp = new Double[size][size];
        this.tempBrzegowa = tempBrzegowa;
        init();
        //this.temp[3][3]=2.7;
    }

    public void init() {
        for (int i = 0; i < this.size; i++)
            for (int j = 0; j < this.size; j++)
                this.temp[i][j] = 0.0;
    }

    public void print() {
        AnsiConsole.systemInstall();
        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < size + 2; j++) {
                if ((j == 0 && i <= size / 2 + 1) || j == size + 1 || i == 0) {
                    System.out.print(ansi().fg(RED).a(tempBrzegowa).reset() + "\t");
                    continue;
                } else if (j == 0) {
                    System.out.print("\t");
                    continue;
                }
                if (i <= size / 2 || (i > size / 2 && j > size / 2))
                    System.out.print(ansi().fg(YELLOW).a(temp[i - 1][j - 1]).reset() + "\t");
                else if (i == size / 2 + 1 || j == size / 2)
                    System.out.print(ansi().fg(BLUE).a("0.0").reset() + "\t");
                else
                    System.out.print("\t");
            }
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }
        for (int i = 0; i < size / 2; i++)
            System.out.print("\t");
        for (int i = size / 2; i < size + 2; i++)
            System.out.print(ansi().fg(RED).a(tempBrzegowa).reset() + "\t");
    }
}
