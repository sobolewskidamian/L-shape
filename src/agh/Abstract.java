package agh;

public abstract class Abstract {
    protected int translate(int e, int i){
        int[][] arr = {{3,4,1,0},{4,5,2,1},{6,7,5,4}};
        return arr[e][i];
    }

    protected double fi(int e, int i, double x1, double x2, int[][] b) {
        if (i == 0)
            return (1 - (x1 - b[e][0])) * (1 - (x2 - b[e][1]));
        else if (i == 1)
            return (x1 - b[e][0]) * (1 - (x2 - b[e][1]));
        else if (i == 2)
            return (x1 - b[e][0]) * (x2 - b[e][1]);
        else
            return (1 - (x1 - b[e][0])) * (x2 - b[e][1]);
    }

    protected double pochodna(int i, int xi) {
        if ((i == 3 && xi == 2) || (i == 2) || (i == 1 && xi == 1))
            return 0.5;
        else
            return -0.5;
    }

    protected static double round(double value, int places) {
        double factor = Math.pow(10, places);
        value = value * factor;
        double tmp = Math.round(value);
        return tmp / factor;
    }

    protected Double root(Double base, Double n) {
        return Math.pow(Math.E, Math.log(base) / n);
    }

    protected double[] gauss(double[][] A, double[] b) {
        int n = b.length;

        for (int p = 0; p < n; p++) {
            int max = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                    max = i;
                }
            }
            double[] temp = A[p];
            A[p] = A[max];
            A[max] = temp;
            double t = b[p];
            b[p] = b[max];
            b[max] = t;

            for (int i = p + 1; i < n; i++) {
                double alpha = A[i][p] / A[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < n; j++) {
                    A[i][j] -= alpha * A[p][j];
                }
            }
        }

        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }
        return x;
    }
}
