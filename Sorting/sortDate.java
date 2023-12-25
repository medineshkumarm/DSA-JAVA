
public class sortDate {
    public static void main(String[] args) {
        String[] arr = { "05121968", "17121996", "05061997", "11081972", "11081990" };
        sortDates(arr);

        for (String s : arr) {
            System.out.print(s + " ");
        }
    }

    public static void sortDates(String[] arr) {
        countSort(arr, 31, 1000000, 100); // on the basis of DD
        countSort(arr, 12, 10000, 100); // on the basis of MM
        countSort(arr, 2500, 1, 10000); // on the basis of YYYY

    }

    public static void countSort(String[] arr, int range, int div, int mod) {
        int n = arr.length;
        int[] p = new int[range + 1]; // range of digits +> [0,9]

        // 1.Create the frequency arr
        for (int i = 0; i < n; i++) {
            p[(Integer.parseInt(arr[i]) / div) % mod]++;
        }

        // 2.Convert this arr into Psum array:
        for (int i = 1; i < p.length; i++) {
            p[i] = p[i - 1] + p[i];
        }

        // 3. Traverse on the original array and try to update ans[]:
        String[] ans = new String[n];
        for (int i = n - 1; i >= 0; i--) {
            int pos = p[(Integer.parseInt(arr[i]) / div) % mod];
            ans[pos - 1] = arr[i];
            p[(Integer.parseInt(arr[i]) / div) % mod]--;
        }

        // cpoy your ans in the original array:
        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }

    }
}
