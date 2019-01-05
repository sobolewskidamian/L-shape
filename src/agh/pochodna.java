package agh;

public class pochodna {
    private int xi;
    private int i;

    public pochodna(int i, int xi) {
        this.xi = xi;
        this.i = i;
    }

    public double solve() {
        if ((this.i == 3 && this.xi == 2) || (this.i == 2) || (this.i == 1 && this.xi == 1))
            return 0.5;
        else
            return -0.5;
    }
}
