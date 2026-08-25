class Solution {
    public int lengthOfLastWord(String s) {

        int i = s.length() - 1;

        // Remove spaces from the end
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        int length = 0;

        // Count characters of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}