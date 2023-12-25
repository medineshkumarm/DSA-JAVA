import java.util.*;

public class fibonacci {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(fibTab(n));
        // System.out.println(fib(n, new int[n + 1]));
    }

    //iteration method or bottom -up or tabulation method:
    //T.C = O(n)
    //S.C = O(n)
    public static int fibTab(int n) {
        int[] dp = new int[n + 1]; // we need to store answer of fib(n) at nth index
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];

        }
        return dp[n];
    }

    // memorisation technique (top-down)
    public static int fib(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        int fn = fib(n - 1, dp) + fib(n - 2, dp);
        dp[n] = fn;
        return fn;
    }
}