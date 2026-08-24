import java.util.*;

class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        // Create empty board
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Start placing queens from row 0
        backtrack(0, n, board, result);

        return result;
    }

    private void backtrack(
            int row,
            int n,
            char[][] board,
            List<List<String>> result) {

        // All queens placed
        if (row == n) {
            result.add(createBoard(board));
            return;
        }

        // Try every column in current row
        for (int col = 0; col < n; col++) {

            // Check whether queen can be placed
            if (isSafe(board, row, col, n)) {

                // Place queen
                board[row][col] = 'Q';

                // Move to next row
                backtrack(row + 1, n, board, result);

                // Backtrack
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(
            char[][] board,
            int row,
            int col,
            int n) {

        // Check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> createBoard(char[][] board) {

        List<String> solution = new ArrayList<>();

        for (char[] row : board) {
            solution.add(new String(row));
        }

        return solution;
    }
}