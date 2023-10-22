import java.util.ArrayList;
import java.util.List;

public class Activity_Selection {

    public static void main(String[] args) {
        int s[] = {0, 1, 3, 0, 5, 3,5, 6, 8, 8, 2, 12};
        int f[] = {0, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        List<Integer> list = activitySelection(s, f, s.length - 1);
        for (Integer integer : list) {
            System.out.print(list);
        }
    }
    public static List<Integer> activitySelection(int s[], int f[], int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        // 贪心策略：最先活动结束时间
        for (int i = 2, j = 1; i <= n;) {
            if (f[j] <= s[i]) {
                list.add(i);
                j = i;
            }
            i++;
        }
        return list;
    }
}
