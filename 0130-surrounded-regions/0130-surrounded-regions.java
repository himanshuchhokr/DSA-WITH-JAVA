class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        // Mark all border-connected O cells as safe.
        for (int row = 0; row < rows; row++) {
            dfs(board, row, 0);
            dfs(board, row, cols - 1);
        }

        for (int col = 0; col < cols; col++) {
            dfs(board, 0, col);
            dfs(board, rows - 1, col);
        }

        // Capture enclosed regions; restore safe cells.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == '#') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols
                || board[row][col] != 'O') {
            return;
        }

        board[row][col] = '#'; // Safe: connected to the border

        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}