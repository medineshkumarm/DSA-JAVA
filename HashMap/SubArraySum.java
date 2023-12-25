import java.util.*;

public class SubArraySum {
    public static void main(String[] args) {
        int[] arr = { 9, 4, 20, 3, 10, 5 };
        System.out.println(subarrayWithSumK(arr, 33));
    }

    public static int subarrayWithSumK(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;

        int psum = 0;
        for (int i = 0; i < arr.length; i++) {
            psum += arr[i];
            if (map.containsKey(psum - target) == true) {
                ans += map.get(psum - target);
            }
            map.put(psum, map.getOrDefault(psum, 0) + 1);
        }
        return ans;
    }
}
