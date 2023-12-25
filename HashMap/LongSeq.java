import java.util.*;

public class LongSeq {
    public static void main(String[] args) {
        int[] arr = { 11, 7, 1, 17, 6, 2, 3, 16, 8, 4, 9, 10, 15 };
        System.out.println(longConsSeq(arr));
    }

    public static int longConsSeq(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        // step1: Assume every element as starting point of lcs:
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], true);
        }

        // step2: consider only valid sp:
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] - 1) == true) {
                map.put(arr[i], false);
            }
        }

        // step3: check for the next integer in the map:
        int maxLen = 1;
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == true) {
                int currLen = 1;
                int val = arr[i];

                while (map.containsKey(val + 1) == true) {
                    currLen++;
                    val++;
                }
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;

    }
}
