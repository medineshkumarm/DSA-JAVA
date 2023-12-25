import java.util.*;

public class Staircase {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the no of stairs:");
        int n = input.nextInt();

        // System.out.println(climbStairs(n, new int[n + 1]));
        System.out.println(climbStairsTab(n));
    }

    // memorisation method(bottom up)
    public static int climbStairs(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        if (dp[n] != 0) {
            return dp[n];
        }
        int f1 = climbStairs(n - 1, dp);
        int f2 = climbStairs(n - 2, dp);
        int f3 = climbStairs(n - 3, dp);

        int ans = f1 + f2 + f3;
        dp[n] = ans;
        return ans;
    }

    public static int climbStairsTab(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

        }
        return dp[n];
    }
}
