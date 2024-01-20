public class sudoku {
    public static void main(String[] args) {
        char[][] sudokuGrid = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        System.out.println("Sudoku Grid before solving:");
        printSudokuGrid(sudokuGrid);
        System.out.println();

        System.out.println("\nSudoku Grid after solving:");
        solveSudoku(sudokuGrid);

    }

    public static void solveSudoku(char[][] arr) {
        if (sudokuSolver(arr, 0, 0)) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static boolean sudokuSolver(char[][] arr, int x, int y) {
        if (x == arr.length) {
            return true;
        }

        int nx = y == 8 ? x + 1 : x;
        int ny = y == 8 ? 0 : y + 1;

        if (arr[x][y] == '.') {
            for (int val = 1; val <= 9; val++) {
                if (canWePlace(arr, x, y, val)) {
                    arr[x][y] = (char) (val + '0');
                    if (sudokuSolver(arr, nx, ny)) {
                        return true;
                    }
                    arr[x][y] = '.';
                }
            }
        } else {
            if (sudokuSolver(arr, nx, ny)) {
                return true;
            }
        }
        return false;
    }

    public static boolean canWePlace(char[][] arr, int x, int y, int val) {
        // Check the row
        for (int col = 0; col < arr[0].length; col++) {
            if (arr[x][col] == (char) (val + '0')) {
                return false;
            }
        }

        // Check the column
        for (int row = 0; row < arr.length; row++) {
            if (arr[row][y] == (char) (val + '0')) {
                return false;
            }
        }

        // Check the 3x3 grid
        int startX = 3 * (x / 3);
        int startY = 3 * (y / 3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[startX + i][startY + j] == (char) (val + '0')) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void printSudokuGrid(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
