class Solution {
    public int minCut(String s) {
        int n = s.length();

        // dp[i] = minimum cuts needed for substring s[0...i]
        int[] dp = new int[n];

        // palindrome[i][j] tells whether s[i...j] is a palindrome
        boolean[][] palindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i] = i; // Maximum cuts needed
        }

        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {

                if (s.charAt(start) == s.charAt(end) &&
                    (end - start <= 2 ||
                     palindrome[start + 1][end - 1])) {

                    palindrome[start][end] = true;

                    if (start == 0) {
                        dp[end] = 0;
                    } else {
                        dp[end] = Math.min(
                            dp[end],
                            dp[start - 1] + 1
                        );
                    }
                }
            }
        }

        return dp[n - 1];
    }
}
