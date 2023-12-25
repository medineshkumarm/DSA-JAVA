import java.util.*;

public class majorityElement {

    public static void main(String[] args) {
        int[] arr = { 5, 2, 4, 2, 4, 4, 5, 4, 7, 4, 4, 2, 2, 2, 2, 2, 2, 2, 2 };
        // System.out.println(findMajorityElement(arr, arr.length));
        System.out.println(findMajoritywithHashMap(arr, arr.length));
    }

    public static int findMajoritywithHashMap(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                count++;
            }
            map.put(arr[i], count);
        }
        System.out.println(map);
        return count;


    }

    public static int findMajorityElement(int[] arr, int n) {
        int candidate = arr[0];
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] == candidate) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                candidate = arr[i];
                count = 1;
            }
        }

        // verify if candidate is ans or not:
        count = 0;
        for (int val : arr) {
            if (val == candidate) {
                count++;
            }
        }

        if (count > n / 2) {
            return candidate;
        } else {
            return -1;
        }
    }
}
// time complexity: O(n)
// Space complexity : O(1)