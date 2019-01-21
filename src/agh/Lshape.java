package agh;

public class Lshape extends Abstract {
    private double B[][];
    private double L[];
    private double gTemp;
    private int size;
    private int b[][] = {{-1, 0}, {0, 0}, {0, -1}};

    public Lshape(int size, double gTemp) {
        this.size = size - 1;
        this.gTemp = gTemp;
    }

    public void solve() {
        this.B = new double[8][8];
        this.L = new double[8];

        for (int e = 0; e < 3; e++) {
            for (int i = 0; i < 4; i++) {
                int i1 = super.translate(e, i);
                if (e == 0)
                    L[i1] += (g(-1.0, 0.5) * super.fi(e, i, -1, 0.5, this.b)) + (g(-0.5, 1) * super.fi(e, i, -0.5, 1, this.b));
                else if (e == 1)
                    L[i1] += g(0.5, 1) * super.fi(e, i, 0.5, 1, this.b) + g(1, 0.5) * super.fi(e, i, 1, 0.5, this.b);
                else if (e == 2)
                    L[i1] += g(1, -0.5) * super.fi(e, i, 1, -0.5, this.b) + g(0.5, -1) * super.fi(e, i, 0.5, -1, this.b);

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
                L[i] = 0;

        B[3][3] = 1;
        B[4][4] = 1;
        B[6][6] = 1;

        double[] arrFromGauss = super.gauss(B, L);

        double[][] result = new double[this.size + 1][this.size + 1];
        Linspace xs = new Linspace(1, -1, this.size);
        Linspace ys = new Linspace(-1, 1, this.size);

        for (int i = 0; i < this.size + 1; i++) {
            double x = xs.getNextFloat();
            for (int j = 0; j < this.size + 1; j++) {
                double y = ys.getNextFloat();
                int e;
                if (y > 0) {
                    if (x > 0)
                        e = 1;
                    else
                        e = 0;
                } else if (x > 0)
                    e = 2;
                else
                    continue;

                for (int v = 0; v < 4; v++) {
                    int i1 = super.translate(e, v);
                    result[i][j] += arrFromGauss[i1] * super.fi(e, v, x, y, this.b);
                }
            }
            ys = new Linspace(-1, 1, this.size);
        }

        for (int a = 0; a < this.size + 1; a++) {
            for (int x = 0; x < this.size + 1; x++)
                result[a][x] = super.round(result[a][x], 3);
        }

        Plate plate = new Plate(this.size + 1);
        plate.init(result);
        plate.print();
    }

    private double g(double x, double y) {
        double r = super.root(x * x + y * y, 2.0);
        double alfa = Math.atan2(y, x);
        //return root(Math.pow(r,2), 3.0) * root(Math.pow(Math.sin(alfa + Math.PI / 4), 2), 3.0); //funkcja z Lshape
        return this.gTemp * r;
    }
}