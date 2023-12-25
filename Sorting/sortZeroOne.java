public class sortZeroOne {
    public static void main(String[] args) {
        // for sort01
        // int[] arr = { 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0 };

        // for sort012
        // int[] arr = { 0, 1, 1, 0, 2, 1, 0, 2, 0, 2, 1 };

        // for countSort algorithm:
        int[] arr = { 6, 8, 1, 3, 1, 4, 9, 1, 2, 8, 8, 7 };
        int[] ans = countingSortAlgo(arr);
        // sort01(arr);
        // sort012(arr);

        // for (int val : arr) {
        // System.out.print(val + " ");
        // }


        for (int val : ans) {
            System.out.print(val + " ");
        }
    }

    public static void sort01(int[] arr) {
        int i = 0, j = 0;
        while (i < arr.length) {
            if (arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j++;
            } else {
                i++;
            }
        }
    }

    public static void sort012(int[] arr) {
        int i = 0, j = 0, k = arr.length - 1;
        while (i <= k) {
            if (arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j++;
            } else if (arr[i] == 2) {
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;

                k--;
                // i++; becz we dont know what is comin from RHS
            } else {
                i++;
            }
        }
    }

    public static int[] countingSortAlgo(int[] arr) {
        int n = arr.length;
        int max = arr[0];

        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }

        int[] p = new int[max + 1];

        // 1.Create the frequency arr
        for (int i = 0; i < n; i++) {
            p[arr[i]]++;
        }

        // 2.Convert this arr into Psum array:
        for (int i = 1; i < p.length; i++) {
            p[i] = p[i - 1] + p[i];
        }

        // 3. Traverse on the original array and try to update ans[]:
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int pos = p[arr[i]];
            ans[pos - 1] = arr[i];
            p[arr[i]]--;
        }
        return ans;
    }
}
