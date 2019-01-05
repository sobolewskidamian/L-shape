package agh;

public class lshape {
    private double B[][];
    private double L[];

    public void solve() {
        this.B = new double[8][8];
        this.L = new double[8];
        for (int e = 0; e <3; e++) {
            for (int i = 0; i <4; i++) {
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
                if (i == 3 || i == 4 || i == 6)
                    B[i][j] = 0;



        L[3] = 0;
        L[4] = 0;
        L[6] = 0;
        B[3][3] = 1;
        B[4][4] = 1;
        B[6][6] = 1;


        System.out.println();
        System.out.println();
        double[] wynik = new Gauss().solve(B,L);
        for(int i=0;i<wynik.length;i++)
            System.out.println(wynik[i]);
    }
}
