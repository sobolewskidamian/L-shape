package agh;

public class myg {
    private double x;
    private double y;

    public myg(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double solve() {
        double alfa = Math.atan2(y,x);
        double r = x * x + y * y;
        //return root(r, 3.0) * root(Math.pow(Math.sin(alfa + Math.PI / 4), 2), 3.0);
        return 2*r*r/2;
    }

    public Double root(Double base, Double n) {
        return Math.pow(Math.E, Math.log(base)/n);
    }
}
