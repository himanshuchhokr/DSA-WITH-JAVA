class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        }

        // dp[i] = number of ways to decode first i characters
        int[] dp = new int[n + 1];

        dp[0] = 1; // Empty string
        dp[1] = 1; // First character is non-zero

        for (int i = 2; i <= n; i++) {
            // Take the current digit as a single character
            char current = s.charAt(i - 1);

            if (current != '0') {
                dp[i] += dp[i - 1];
            }

            // Take the last two digits as a number
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
