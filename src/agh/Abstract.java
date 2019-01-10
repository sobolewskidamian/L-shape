package agh;

public abstract class Abstract {
    protected int translate(int e, int i){
        int[][] r = {{3,4,1,0},{4,5,2,1},{6,7,5,4}};
        return r[e][i];
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
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
