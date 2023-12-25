import java.util.*;

public class nQueen {
    public static void main(String[] args) {
        int n = 4;
        char[][] arr = new char[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = '.';
            }
        }
        nQueensOptim(arr, 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
    }

    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");

            }
            System.out.println();
        }
    }

    public static boolean isSafe(char[][] arr, int row, int col) {
        // checking column
        for (int i = 0; i < row; i++) {
            if (arr[i][col] == 'Q') {
                return false;
            }
        }

        // checking diagonal1
        for (int i = row - 1, j = col + 1; i >= 0 && j < arr[0].length; i--, j++) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }
        // checking diagonal2
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void nQueens(char[][] arr, int row) {
        if (row == arr.length) {
            // decided for every row
            print(arr);
            System.out.println("___________________");
            return;
        }

        for (int col = 0; col < arr[0].length; col++) {
            if (isSafe(arr, row, col) == true) {
                arr[row][col] = 'Q';
                nQueens(arr, row + 1);
                arr[row][col] = '.';
            }
        }
    }

    public static void nQueensOptim(char[][] arr, int row, boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == arr.length) {
            // decided for every row
            print(arr);
            System.out.println("___________________");
            return;
        }

        for (int col = 0; col < arr[0].length; col++) {
            if (cols[col] == false && d1[row + col] == false && d2[row - col + arr.length - 1] == false) {
                arr[row][col] = 'Q';
                cols[col] = true;
                d1[row + col] = true;
                d2[row - col + arr.length - 1] = true;
                nQueensOptim(arr, row + 1, cols, d1, d2);
                arr[row][col] = '.';
                cols[col] = false;
                d1[row + col] = false;
                d2[row - col + arr.length - 1] = false;

            }
        }
    }
}
