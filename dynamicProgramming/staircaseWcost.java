import java.util.*;

public class staircaseWcost {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 3, 6, 5, 2, 7, 1 };
        // System.out.println(climbStairs2(arr, arr.length, new int[arr.length + 1]));
        System.out.println(climbStairs2Tab(arr));

    }

    // memorisation method:
    public static int climbStairs2(int[] arr, int n, int[] dp) {

        if (n == 1) {
            return arr[0];
        }
        if (n == 2) {
            return arr[0] + arr[1];
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int f1 = climbStairs2(arr, n - 1, dp);
        int f2 = climbStairs2(arr, n - 2, dp);
        int ans = Math.min(f1, f2) + arr[n - 1];
        dp[n] = ans;
        return ans;
    }

    public static int climbStairs2Tab(int[] arr) {
        int[] dp = new int[arr.length];

        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + arr[i];

        }
        return dp[dp.length - 1];
    }
    //TC = O(n)
    //SC = O(n)
}
