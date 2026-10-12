class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();

        backtrack(s, 0, path, result);

        return result;
    }

    private void backtrack(String s, int start,
                           List<String> path,
                           List<List<String>> result) {

        // Base case: entire string is partitioned
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Try every possible substring
        for (int end = start; end < s.length(); end++) {

            String sub = s.substring(start, end + 1);

            // Check whether substring is a palindrome
            if (isPalindrome(sub)) {

                // Choose
                path.add(sub);

                // Explore
                backtrack(s, end + 1, path, result);

                // Backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
