package agh;

public class Plate {
    private int size;
    private double[][] tempArr;

    public Plate(int size, double[][] resultArr) {
        this.size = size;
        this.tempArr = resultArr;
    }

    public void print() {
        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < size + 2; j++) {
                if ((j == 0 && i <= size / 2 + 1) || j == size + 1 || i == 0 || j == 0) {
                    System.out.print("\t");
                    continue;
                }
                if (i <= size / 2 + 1 || (i > size / 2 && j > (size - 1) / 2))
                    System.out.print(tempArr[i - 1][j - 1] + "\t");
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
