public class firstAndLast {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 8 };
        firstAndLastPosition(arr, 3);

    }

    public static void firstAndLastPosition(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int first = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = 0;
        right = arr.length - 1;
        int last = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(first + " " + last);
    }
}

// T.C = O(log n )
// S.C = O(1)