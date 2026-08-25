class Solution {
    public String getPermutation(int n, int k) {

        // Store numbers 1 to n
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // Factorials
        int[] factorial = new int[n + 1];
        factorial[0] = 1;

        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        // Convert k to 0-based index
        k--;

        StringBuilder result = new StringBuilder();

        for (int i = n; i >= 1; i--) {

            // Find which block k belongs to
            int index = k / factorial[i - 1];

            // Select that number
            result.append(numbers.get(index));

            // Remove selected number
            numbers.remove(index);

            // Update k
            k = k % factorial[i - 1];
        }

        return result.toString();
    }
}