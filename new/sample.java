public class sample {
    public static void main(String[] args) {
        int a = 123;
        
        int[] resultArray = convertToArray(a);
        
        // Print the resulting array
        for (int num : resultArray) {
            System.out.print(num + " ");
        }
    }

    public static int[] convertToArray(int number) {
        // Count the number of digits in the number
        int temp = number;
        int count = 0;
        while (temp != 0) {
            temp /= 10;
            count++;
        }

        // Create an array to store individual digits
        int[] resultArray = new int[count];

        // Extract individual digits and store them in the array
        for (int i = count - 1; i >= 0; i--) {
            resultArray[i] = number % 10;
            number /= 10;
        }

        return resultArray;
    }
}
// class Solution {
//     public boolean isHappy(int n) {
//         int slow = n;
//         int fast = n;
//         do {
//             slow = square(slow);
//             fast = square(square(fast));
//         } while (slow != fast);
//         return slow == 1;
//     }

//     public int square(int n) {
//         int ans = 0;
//         while (n > 0) {
//             int mod = n % 10;
//             n = n / 10;
//             ans += mod * mod;

//         }
//         return ans;
//     }
// }