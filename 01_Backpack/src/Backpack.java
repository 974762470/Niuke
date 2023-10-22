public class Backpack {
    public static void main(String[] args) {
        int []weights = {0, 3, 4, 7, 8, 9};
        float []values = {0, 4, 5, 10, 11, 13};
        int W = 17;
        int n = 5;
        float c[][] = backpack(n, W, weights, values);
        int x[] = solution(c, n, W, weights);
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                System.out.print(c[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < n; i ++)
            System.out.print(x[i] + " ");

    }
    public static float[][] backpack(int n, int W, int weights[], float values[]) {
        float c[][] = new float[n + 1][W + 1];
        // 初始化c[][]  c[i][w]表示背包容量为w时，i个物品的最优解
        for (int i = 0; i <= n; i++)
            c[i][0] = 0;
        for (int j = 0; j <= W; j++)
            c[0][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (w < weights[i])   //不装入
                    c[i][w] = c[i - 1][w];
                else c[i][w] = Math.max(c[i - 1][w - weights[i]] + values[i], c[i - 1][w]);
            }
        }

        return c;
    }
    public static int[] solution(float c[][], int n, int W, int weights[]) {
        int x[] = new int[n];
        for (int i = n; i >= 1; i--){
            if (c[i][W] == c[i - 1][W])  //没选中
                x[i - 1] = 0;
            else {
                x[i - 1] = 1;
                W = W - weights[i];
            }
        }
        return  x;
    }
}
