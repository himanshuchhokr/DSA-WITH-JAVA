class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);

        if (!dictionary.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int length = 1; // beginWord itself counts

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                String word = queue.poll();
                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;

                        chars[i] = c;
                        String nextWord = new String(chars);

                        if (nextWord.equals(endWord)) {
                            return length + 1;
                        }

                        if (dictionary.remove(nextWord)) {
                            queue.offer(nextWord);
                        }
                    }

                    chars[i] = original;
                }
            }

            length++;
        }

        return 0;
    }
}