package agh;

public class Linspace extends Abstract {
    private float current;
    private final float end;
    private final float step;

    public Linspace(float start, float end, float totalCount) {
        this.current = start;
        this.end = end;
        this.step = (end - start) / totalCount;
    }

    public double getNextFloat() {
        double act = super.round(current, 6);
        current += step;
        return act;
    }


}
