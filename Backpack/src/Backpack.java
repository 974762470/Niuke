public class Backpack {
    public static void main(String[] args) {
        int []w = {30, 10, 20, 50, 40};
        int []v = {65, 20, 30, 60, 40};
        double []v_w = {2.1, 2, 1.5, 1.2, 1};
        int n =5;
        int W = 100;
        float[] floats = backpack(w, v, v_w, n, W);
        for (float aFloat : floats) {
            System.out.print(aFloat + " ");
        }
    }
    public static float[] backpack(int w[], int v[], double v_w[], int n, int W) {
        float x[] = new float[n];
        int i = 0;
        for (i = 0; i < n; i++) {
            if (w[i] < W) {
                x[i] = 1;
                W -= w[i];
            }else break;
        }
        if (i < n) {
            x[i] = W / (float)w[i];
        }
        return x;
    }
}
