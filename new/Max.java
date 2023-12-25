import java.util.HashMap;
import java.util.Map;

public class Max {
    public static void main(String[] args) {
        // Example array of numbers
        int[] array = { 11, 12, 3, 4, 5 };

        // Call the function to find the maximum length subsequence
        int result = maxLengthSubsequence(array);

        // Print the result
        System.out.println(result);
    }

    static int maxLengthSubsequence(int[] array) {
        // Create a map to remember the last occurrence of each digit
        Map<Character, Integer> lastOccurrence = new HashMap<>();

        // Initialize the maximum length of the subsequence
        int maxLength = 0;

        // Loop through each number in the array
        for (int i = 0; i < array.length; i++) {
            // Convert the absolute value of the number to characters
            char[] digits = Integer.toString(Math.abs(array[i])).toCharArray();

            // Loop through each digit
            for (char digit : digits) {
                // Check if the digit was seen before
                if (lastOccurrence.containsKey(digit)) {
                    // Calculate the length of the subsequence and update maxLength
                    maxLength = Math.max(maxLength, i - lastOccurrence.get(digit) + 1);
                    // Break out of the loop since we found a common digit
                    break;
                }
            }

            // Update the last occurrence of each digit
            for (char digit : digits) {
                lastOccurrence.put(digit, i);
            }
        }

        // Return the maximum length of the subsequence
        return maxLength;
    }
}
