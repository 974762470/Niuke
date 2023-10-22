import sun.security.util.Length;

import java.util.Stack;

public class LCS {
    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";
        int b[][] = lcs(X, Y);
        Stack<Character> stack = new Stack<Character>();
        for (int i = X.length(), j = Y.length(); i >= 1&&j >= 1;) {
            if (b[i][j] == 0) {
//                System.out.print(X.charAt(i - 1));
                stack.push(X.charAt(i - 1));
                i--;
                j--;
            }else if (b[i][j] == 1) {
                i--;
            }else j--;
        }
        while (!stack.isEmpty())
            System.out.print(stack.pop());
        stack.clear();
    }
    public static int[][] lcs(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        int l[][] = new int[length1 + 1][length2 + 1];
        int b[][] = new int[length1 + 1][length2 + 1];
        //初始化
        for (int i = 0; i <= length1; i++)
            l[i][0] = 0;
        for (int j = 0; j <= length2; j++)
            l[0][j] = 0;

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    l[i][j] = l[i - 1][j - 1] + 1;
                    b[i][j] = 0;   // 0代表左上
                }
                else if (l[i - 1][j] >= l[i][j - 1]){
                    l[i][j] = l[i - 1][j];
                    b[i][j] = 1;  //1 代表上
                }else {
                    l[i][j] = l[i][j - 1];
                    b[i][j] = 2;   //2代表左
                }
            }
        }
        return b;
    }
}
