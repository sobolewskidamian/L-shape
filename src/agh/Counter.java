package agh;

public class Counter {
    public int translate(int e, int i){
        int[][] r = new int[3][4];
        r[0][0]=3;
        r[0][1]=4;
        r[0][2]=1;
        r[0][3]=0;

        r[1][0]=4;
        r[1][1]=5;
        r[1][2]=2;
        r[1][3]=1;

        r[2][0]=6;
        r[2][1]=7;
        r[2][2]=5;
        r[2][3]=4;
        return r[e][i];
    }
}
