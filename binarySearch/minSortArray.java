
public class minSortArray {
    public static void main(String[] args) {
        int[] arr = { 9, 11, 14, 15, 20, 25, 1, 2, 3, 5, 7 };

        System.out.println(findMin(arr));
    }

    public static int findMin(int[] arr) {
        int left = 0, right = arr.length - 1;
        // when comparing mid and right if right is greater than mid element then the
        // array is in sorted order . so finding the minimum is not possible.
        // therefore discard right portion
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < arr[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr[left];
    }
}

// T.C = O(log n)
// S.C = O(1)