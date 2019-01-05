package agh;

public class pochodna {
    private int xi;
    private int i;

    public pochodna(int xi, int i) {
        this.xi = xi;
        this.i = i;
    }

    public double solve() {
        if ((this.i == 4 && this.xi == 2) || (this.i == 3) || (this.i == 2 && this.xi == 1))
            return 0.5;
        else
            return -0.5;
    }
}
