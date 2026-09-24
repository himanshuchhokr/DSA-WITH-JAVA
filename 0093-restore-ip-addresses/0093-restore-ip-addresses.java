class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        // A valid IP has 4 parts, each containing 1 to 3 digits.
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }

        backtrack(s, 0, 0, new StringBuilder(), result);

        return result;
    }

    private void backtrack(String s, int index, int parts,
                            StringBuilder current,
                            List<String> result) {

        // If we have 4 parts, all digits must have been used
        if (parts == 4) {
            if (index == s.length()) {
                result.add(current.toString());
            }
            return;
        }

        // Try taking 1, 2, or 3 digits
        for (int len = 1; len <= 3; len++) {

            // Not enough characters left
            if (index + len > s.length()) {
                break;
            }

            String part = s.substring(index, index + len);

            // Leading zero is not allowed
            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }

            // Value must be <= 255
            int value = Integer.parseInt(part);

            if (value > 255) {
                break;
            }

            int oldLength = current.length();

            // Add dot before every part except the first
            if (parts > 0) {
                current.append('.');
            }

            current.append(part);

            // Continue with the next part
            backtrack(s, index + len, parts + 1, current, result);

            // Backtrack
            current.setLength(oldLength);
        }
    }
}
