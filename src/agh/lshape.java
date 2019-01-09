package agh;

public class lshape {
    private double B[][];
    private double L[];

    int n;

    private int b[][] = {{-1, 0}, {0, 0}, {0, -1}};

    public lshape(int rozmiar) {
        this.n = rozmiar - 1;
    }

    public void solve() {
        this.B = new double[8][8];
        this.L = new double[8];
        for (int e = 0; e < 3; e++) {
            for (int i = 0; i < 4; i++) {
                int i1 = new Counter().translate(e, i);
                if (e == 0)
                    L[i1] += (new myg(-1.0, 0.5).solve() * new fi(e, i, -1, 0.5).solve()) + (new myg(-0.5, 1).solve() * new fi(e, i, -0.5, 1).solve());
                else if (e == 1)
                    L[i1] += new myg(0.5, 1).solve() * new fi(e, i, 0.5, 1).solve() + new myg(1, 0.5).solve() * new fi(e, i, 1, 0.5).solve();
                else if (e == 2)
                    L[i1] += new myg(1, -0.5).solve() * new fi(e, i, 1, -0.5).solve() + new myg(0.5, -1).solve() * new fi(e, i, 0.5, -1).solve();

                for (int j = 0; j < 4; j++) {
                    int j1 = new Counter().translate(e, j);
                    B[i1][j1] += new pochodna(i, 1).solve() * new pochodna(j, 1).solve() + new pochodna(i, 2).solve() * new pochodna(j, 2).solve();
                }
            }
        }
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if (i == 3 || i == 6 || i == 4)
                    B[i][j] = 0;


        L[3] = 0;
        L[4] = 0;
        L[6] = 0;
        B[3][3] = 1;
        B[4][4] = 1;
        B[6][6] = 1;


        System.out.println();
        System.out.println();
        double[] wynik = new Gauss().solve(B, L);


        double[][] Z = new double[n + 1][n + 1];
        Linspace xs = new Linspace(-1, 1, n);
        Linspace ys = new Linspace(-1, 1, n);

        for (int i = 0; i < n + 1; i++) {
            double x = xs.getNextFloat();
            for (int j = 0; j < n + 1; j++) {
                double y = ys.getNextFloat();
                int k;
                if (y > 0) {
                    if (x > 0)
                        k = 1;
                    else
                        k = 0;
                } else if (x > 0)
                    k = 2;
                else
                    continue;
                int b1 = this.b[k][0];
                int b2 = this.b[k][1];

                double xval = (x - b1);
                double yval = (y - b2);

                for (int v = 0; v < 4; v++) {
                    int i1 = new Counter().translate(k, v);
                    if (v == 0)
                        Z[i][j] += wynik[i1] * (1 - xval) * (1 - yval);
                    else if (v == 1)
                        Z[i][j] += wynik[i1] * (xval) * (1 - yval);
                    else if (v == 2)
                        Z[i][j] += wynik[i1] * (xval) * (yval);
                    else
                        Z[i][j] += wynik[i1] * (1 - xval) * (yval);
                }
            }
            ys = new Linspace(-1, 1, n);
        }


        /*for (int a = n; a >= 0; a--) {
            for (int x = 0; x < n + 1; x++)
                System.out.print(round(Z[a][x], 1) + " ");
            System.out.println();
        }*/


        double[][] wynik2 = new double[n + 1][n + 1];
        for (int a = n; a >= 0; a--) {
            for (int x = 0; x < n + 1; x++)
                wynik2[a][x] = round(Z[n - a][x], 1);
        }

        Plate plate = new Plate(n + 1, 10);
        plate.init(wynik2);
        plate.print();

        /*for(int x=0;x<wynik.length;x++)
            System.out.println(wynik[x]);*/
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
