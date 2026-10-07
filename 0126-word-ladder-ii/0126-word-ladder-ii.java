import java.util.*;

class Solution {
    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList) {

        Set<String> dictionary = new HashSet<>(wordList);
        List<List<String>> answer = new ArrayList<>();

        if (!dictionary.contains(endWord)) {
            return answer;
        }

        // child -> all valid previous words on shortest paths
        Map<String, List<String>> parents = new HashMap<>();

        Set<String> currentLevel = new HashSet<>();
        currentLevel.add(beginWord);

        boolean found = false;

        while (!currentLevel.isEmpty() && !found) {
            Set<String> nextLevel = new HashSet<>();

            // Remove only after a whole level is processed.
            // This preserves multiple parents at the same shortest distance.
            dictionary.removeAll(currentLevel);

            for (String word : currentLevel) {
                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;

                        chars[i] = c;
                        String nextWord = new String(chars);

                        if (dictionary.contains(nextWord)) {
                            nextLevel.add(nextWord);
                            parents
                                .computeIfAbsent(nextWord, key -> new ArrayList<>())
                                .add(word);

                            if (nextWord.equals(endWord)) {
                                found = true;
                            }
                        }
                    }

                    chars[i] = original;
                }
            }

            currentLevel = nextLevel;
        }

        if (!found) {
            return answer;
        }

        LinkedList<String> path = new LinkedList<>();
        path.add(endWord);

        buildPaths(endWord, beginWord, parents, path, answer);
        return answer;
    }

    private void buildPaths(
            String word,
            String beginWord,
            Map<String, List<String>> parents,
            LinkedList<String> path,
            List<List<String>> answer) {

        if (word.equals(beginWord)) {
            List<String> sequence = new ArrayList<>(path);
            Collections.reverse(sequence);
            answer.add(sequence);
            return;
        }

        for (String parent : parents.getOrDefault(word, Collections.emptyList())) {
            path.add(parent);
            buildPaths(parent, beginWord, parents, path, answer);
            path.removeLast();
        }
    }
}