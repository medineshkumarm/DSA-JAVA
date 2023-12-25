
public class mergeSort {
    public static void main(String[] args) {
        int[] arr1 = { 2, 3, 8, 10, 12, 15 };
        int[] arr2 = { 3, 5, 7, 11 };

        //for merge two sorted array:
        // int[] ans = mergeTwoSortedArrays(arr1, arr2);

        int[] arr = { 2, 3, 8, 10, 12, 15, 3, 5, 7, 11 };
        int [] ans = mergeSorting(arr,0, arr.length -1);
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }

    public static int[] mergeSorting(int[] arr, int low, int high) {
        if (low == high) {
            int[] bans = new int[1];
            bans[0] = arr[low];
            return bans;
        }

        int mid = (low + high) / 2;
        int[] fsh = mergeSorting(arr, low, mid);
        int[] ssh = mergeSorting(arr, mid + 1, high);
        int[] ans = mergeTwoSortedArrays(fsh, ssh);

        return ans;
    }

    public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length + arr2.length];

        int i = 0, j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                ans[k] = arr1[i];
                i++;
                k++;
            } else {
                ans[k] = arr2[j];
                j++;
                k++;
            }
        }

        while (i < arr1.length) {
            ans[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            ans[k] = arr2[j];
            j++;
            k++;
        }
        return ans;
    }
}
