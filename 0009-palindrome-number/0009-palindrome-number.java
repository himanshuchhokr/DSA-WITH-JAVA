class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindrome
        if (x < 0) {
            return false;
        }

        // Numbers ending with 0 (except 0 itself)
        if (x != 0 && x % 10 == 0) {
            return false;
        }

        int reversedHalf = 0;

        while (x > reversedHalf) {

            reversedHalf = reversedHalf * 10 + x % 10;

            x /= 10;
        }

        // Even digits
        if (x == reversedHalf) {
            return true;
        }

        // Odd digits
        return x == reversedHalf / 10;
    }
}