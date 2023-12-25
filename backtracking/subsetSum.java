import java.util.*;

public class subsetSum {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };
        tss(arr,0, 60, new ArrayList<>());
    }

    public static void tss(int[] arr, int i, int target, ArrayList<Integer> ans) {
        if (target < 0) {
            return;
        }
        if (i == arr.length) {
            if (target == 0)
                System.out.println(ans);
            return;
        }

        // select i'th element
        ans.add(arr[i]);
        tss(arr, i + 1, target - arr[i], ans);
        ans.remove(ans.size() -1);

        // reject the element
        tss(arr, i + 1, target, ans);

    }
}
