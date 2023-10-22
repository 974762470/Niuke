public class Sum {
    public static void main(String[] args) {
        int array[] = {-2, 11, -4, 13, -5, -2};
        int right = array.length;
        int sum = Maxsubsum(array, 0, right - 1);
        System.out.println(sum);
    }
    public static int Maxsubsum(int array[], int left, int right) {
        int sum = 0;
        if (left == right) {
            if (array[left] > 0)
                sum = array[left];
            else sum =0;
        }else  {
            int mid = (left + right) / 2;
            int l = Maxsubsum(array, left, mid);
            int r = Maxsubsum(array, mid + 1, right);
            int lefts = 0;
            int s1 = 0;
            for(int i = mid; i >= left; i--) {
                lefts += array[i];
                if (lefts > s1)
                    s1 = lefts;
            }
            int rights = 0;
            int s2 = 0;
            for (int i = mid + 1; i <= right; i++) {
                rights += array[i];
                if (rights > s2)
                    s2 = rights;
            }
            sum = s1 + s2;
            if (l > sum) sum = l;
            if (r > sum) sum = r;
        }

        return sum;
    }
}
