public class radixSort {
    public static void main(String[] args) {
        int[] arr = { 7865, 6574, 5643, 99, 110, 9, 92, 778 };
        radixSorting(arr);
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    public static void radixSorting(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int exp = 1;
        while (max > 0) {
            max /= 10;
            countingSortAlgo(arr, exp);
            exp *=10;
        }
    }

    public static void countingSortAlgo(int[] arr, int exp) {
        int n = arr.length;
        int[] p = new int[10]; // range of digits +> [0,9]

        // 1.Create the frequency arr
        for (int i = 0; i < n; i++) {
            p[(arr[i] / exp) % 10]++;
        }

        // 2.Convert this arr into Psum array:
        for (int i = 1; i < p.length; i++) {
            p[i] = p[i - 1] + p[i];
        }

        // 3. Traverse on the original array and try to update ans[]:
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int pos = p[(arr[i] / exp) % 10];
            ans[pos - 1] = arr[i];
            p[(arr[i] / exp) % 10]--;
        }

        // cpoy your ans in the original array:
        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }

    }
}
