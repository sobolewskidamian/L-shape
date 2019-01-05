package agh;

public class myg {
    private int x;
    private int y;

    public myg(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double solve() {
        double alfa = Math.atan2(x, y);
        double r = x * x + y * y;
        return pow(r, 3.0) * Math.pow(pow(Math.sin(alfa + Math.PI / 4), 2.0), 3.0);
    }

    private Double pow(Double base, Double n) {
        return Math.pow(Math.E, Math.log(base) / n);
    }
}
