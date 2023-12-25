import java.util.*;

public class permutation {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        printPermutations(arr, 0, new boolean[arr.length], new ArrayList<>());
    }

    public static void printPermutations(int[] arr, int pos, boolean[] selected, ArrayList<Integer> ans) {

        if(pos == arr.length) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (selected[i] == false) {
                selected[i] = true;
                ans.add(arr[i]);

                printPermutations(arr, pos + 1, selected, ans);
                selected[i] = false;
                ans.remove(ans.size() - 1);
            }
        }
    }
}
