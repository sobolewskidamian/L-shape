package agh;

public class fi {
    private int b[][] = {{-1, 0}, {0, 0}, {0, -1}};
    private double x1;
    private double x2;
    private int e;
    private double i;

    public fi(int e, int i, double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
        this.e = e;
        this.i = i;
    }

    public double solve() {
        if (this.i == 0)
            return (1 - (this.x1 - this.b[this.e][0])) * (1 - (this.x2 - this.b[this.e][1]));
        else if (this.i == 1)
            return (this.x1 - this.b[this.e][0]) * (1 - (this.x2 - this.b[this.e][1]));
        else if (this.i == 2)
            return (this.x1 - this.b[this.e][0]) * (this.x2 - this.b[this.e][1]);
        else
            return (1 - (this.x1 - this.b[this.e][0])) * (this.x2 - this.b[this.e][1]);
    }
}
