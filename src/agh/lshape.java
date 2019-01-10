package agh;

public class lshape extends Abstract {
    private double B[][];
    private double L[];
    private double gTemp;
    private double temperaturaBrzegowaDolna;
    private int rozmiar;
    private int b[][] = {{-1, 0}, {0, 0}, {0, -1}};

    public lshape(int rozmiar, double gTemp, double temperaturaBrzegowaDolna) {
        this.rozmiar = rozmiar - 1;
        this.gTemp = gTemp;
        this.temperaturaBrzegowaDolna = temperaturaBrzegowaDolna;
    }

    public void solve() {
        this.B = new double[8][8];
        this.L = new double[8];
        for (int e = 0; e < 3; e++) {
            for (int i = 0; i < 4; i++) {
                int i1 = super.translate(e, i);
                if (e == 0)
                    L[i1] += (g(-1.0, 0.5) * super.fi(e, i, -1, 0.5, b)) + (g(-0.5, 1) * super.fi(e, i, -0.5, 1, b));
                else if (e == 1)
                    L[i1] += g(0.5, 1) * super.fi(e, i, 0.5, 1, b) + g(1, 0.5) * super.fi(e, i, 1, 0.5, b);
                else if (e == 2)
                    L[i1] += g(1, -0.5) * super.fi(e, i, 1, -0.5, b) + g(0.5, -1) * super.fi(e, i, 0.5, -1, b);

                for (int j = 0; j < 4; j++) {
                    int j1 = super.translate(e, j);
                    B[i1][j1] += super.pochodna(i, 1) * super.pochodna(j, 1) + super.pochodna(i, 2) * super.pochodna(j, 2);
                }
            }
        }

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if (i == 3 || i == 6 || i == 4)
                    B[i][j] = 0;


        for (int i = 0; i < 8; i++)
            if (i == 3 || i == 6 || i == 4)
                L[i] = this.temperaturaBrzegowaDolna;

        B[3][3] = 1;
        B[4][4] = 1;
        B[6][6] = 1;

        double[] wynik = new Gauss().solve(B, L);


        double[][] Z = new double[this.rozmiar + 1][this.rozmiar + 1];
        Linspace xs = new Linspace(-1, 1, this.rozmiar);
        Linspace ys = new Linspace(-1, 1, this.rozmiar);

        for (int i = 0; i < this.rozmiar + 1; i++) {
            double x = xs.getNextFloat();
            for (int j = 0; j < this.rozmiar + 1; j++) {
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
                    int i1 = super.translate(k, v);
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
            ys = new Linspace(-1, 1, this.rozmiar);
        }

        double[][] wynik2 = new double[this.rozmiar + 1][this.rozmiar + 1];
        for (int a = this.rozmiar; a >= 0; a--) {
            for (int x = 0; x < this.rozmiar + 1; x++)
                if (a >= (this.rozmiar + 1) / 2 && x <= this.rozmiar / 2)
                    wynik2[a][x] = this.temperaturaBrzegowaDolna;
                else
                    wynik2[a][x] = super.round(Z[this.rozmiar - a][x], 2);
        }

        Plate plate = new Plate(this.rozmiar + 1, 10);
        plate.init(wynik2);
        plate.print();
    }

    private double g(double x, double y) {
        double r = x * x + y * y;
        //return root(Math.pow(r,2), 3.0) * root(Math.pow(Math.sin(Math.atan2(y,x) + Math.PI / 4), 2), 3.0); //funkcja z lshape
        return this.gTemp * r;
    }

    private Double root(Double base, Double n) {
        return Math.pow(Math.E, Math.log(base) / n);
    }

}
