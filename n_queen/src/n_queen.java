public class n_queen {

    int n = 4;
    int x[] = new int[n + 1];  //存放皇后结果
    public void backtrack(int i) {
        if (i > n) {
            for (int k = 1; k <= n; k++)
                System.out.print(x[k] + " ");
            System.out.println();
            return;
        }
        int j = 1;
        while (j <= n) {
            x[i] = j;  // 对第i行从位置1到n依次赋值
            if (place(i)) {
                backtrack(i + 1);
            }
            j++;
        }

    }
    public boolean place(int k) {    //测试第k行的j位置能否放置皇后
        int i = 1;   // 1~k-1 是已放置皇后的行
        while (i < k)
        {
            if (x[i] == x[k] || (Math.abs(x[i] - x[k]) == Math.abs(i - k)))
                return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        n_queen nQueen = new n_queen();
        nQueen.backtrack(1);
    }
}
