public class Backpack {
    int bestv = 0;  //最优价值
    int cv = 0; //当前获得的物品价值
    int cw = 0; //背包当前重量
    int values[] = {0, 11, 21, 31, 33, 43, 53, 55, 65};
    int weights[] = {0, 1, 11, 21, 23, 33, 43, 45 ,55};
    int n = 8;  //物品个数
    int W = 110;  //背包总容量
    int []put = new int[n];  //物品放入背包情况
    public void backpack(int i, int put []) {
        if (i > n) {
            if (cv > bestv){
                bestv = cv;
                for (int k = 0; k < put.length; k++){
                    System.out.print( put[k]+" ");
                }
                System.out.print("最大价值：" + bestv);
                System.out.println();
            }
            return;
        }
        //如若左子节点可行，则直接搜索左子树;
        //对于右子树，先计算上界函数，以判断是否将其减去
        if (cw + weights[i] < W) {
            put[i - 1] = 1;
            cw += weights[i];
            cv += values[i];
            backpack(i + 1, put);   //深度搜索 进入下一层
            cw -= weights[i];  //回溯复原
            cv -= values[i];    //回溯复原
            put[i - 1] = 0;
        }
        if (bound(i + 1) > bestv){
            backpack(i + 1, put);
        }

    }
    //计算上界函数, 剪枝
    public int bound(int i) {
        //判断当前背包的总价值cv＋剩余容量可容纳的最大价值<=当前最优价值
        int leftw = W - cw;  //剩余背包容量
        int b = cv; //记录当前背包总价值
        while (i <= n && weights[i] <= leftw) {
            b += values[i];
            leftw -= weights[i];
            i++;
        }
        if (i <= n) {
            b += leftw * (values[i] / weights[i]);
        }
        return b;
    }
    public static void main(String[] args) {
        Backpack bp = new Backpack();
        int[] put = bp.put;
        bp.backpack(1, put);


    }
}


