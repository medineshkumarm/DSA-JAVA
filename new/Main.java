import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // int[] arr = {0,1,5,3,4,2};
        // int[] arr = { 0 };
        // int[] ans = arrPermut(arr);

        // for (int k = 0; k < ans.length; k++) {
        // System.out.print(ans[k] + " ");
        // }

        // int[] arr = { 1, 2, 2, 3, 3, 3 };
       
        // System.out.println(findLucky(arr));
    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int number = 0 ;
       for(int num: nums){
           int occurence = map.get(num);
           if(occurence == 1){
               number = occurence;
           }
       }
       return number;
    }

    public static int[] arrPermut(int[] nums) {
        if (nums.length <= 0) {
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                nums[i] = i;
            } else {
                // int temp = nums[i];
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
                // nums[nums[i]] = temp;
            }
        }

        return nums;
    }

    public static int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxLuck = -1;
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        // int num = entry.getKey(); // Corrected method name to getKey()
        // int frequency = entry.getValue(); // Corrected method name to getValue()

        // if (num == frequency && num > maxLuck) {
        // maxLuck = num;
        // }
        // }

        for (int num : arr) {
            int frequency = map.get(num);

            if (num == frequency && num > maxLuck) {
                maxLuck = num;
            }

        }
        // class Solution {
        // public int findLucky(int[] arr) {
        // int count[] = new int[arr.length + 1];
        // for (final int a : arr) {
        // if (a <= arr.length)
        // count[a]++;
        // } for (int i = arr.length; i >= 1; i--) {
        // if (count[i] == i)
        // return i;
        // }
        // return -1;
        // }
        // }

        System.out.println(map);
        return maxLuck;
    }

    // public static int findLucky(int[] arr) {
    // int count = 1;
    // HashMap<Integer, Integer> map = new HashMap<>();
    // for (int i = 0; i < arr.length -1; i++) {
    // if (!map.containsKey(arr[i])) {
    // map.put(arr[i], count);
    // } else {
    // count++;
    // map.put(arr[i], count);
    // }

    // }
    // int lucky = 0;
    // // for (int i = 0; i < map.size() - 1; i++) {
    // // if (map.containsKey(i) == map.containsValue(i)) {
    // // lucky++;
    // // // System.out.println(map.keySet()+ " lucky ="+ map.values());
    // // System.out.println(map);
    // // }
    // // }

    // System.out.println(map);
    // // }
    // if (lucky == 0) {
    // lucky = -1;
    // }

    // return lucky;
    // }
}
