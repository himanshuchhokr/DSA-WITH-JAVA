class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                char num = board[i][j];

                if (num == '.') {
                    continue;
                }

                // Check Row
                if (!set.add(num + " in row " + i)) {
                    return false;
                }

                // Check Column
                if (!set.add(num + " in col " + j)) {
                    return false;
                }

                // Check 3x3 Box
                if (!set.add(num + " in box " + (i / 3) + "-" + (j / 3))) {
                    return false;
                }
            }
        }

        return true;
    }
}