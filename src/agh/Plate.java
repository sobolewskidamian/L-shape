package agh;

public class Plate {
    private int size;
    private double[][] temp;

    public Plate(int size) {
        this.size = size;
        this.temp = new double[size][size];
    }

    public void init(double[][] a) {
        temp = a;
    }

    public void print() {
        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < size + 2; j++) {
                if ((j == 0 && i <= size / 2 + 1) || j == size + 1 || i == 0 || j == 0) {
                    System.out.print("\t");
                    continue;
                }
                if (i <= size / 2 + 1 || (i > size / 2 && j > (size - 1) / 2))
                    System.out.print(temp[i - 1][j - 1] + "\t");
                else
                    System.out.print("\t");
            }
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }
        for (int i = 0; i < (size + 1) / 2; i++)
            System.out.print("\t");
    }
}
