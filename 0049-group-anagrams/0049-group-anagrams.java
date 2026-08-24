import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // Convert string into character array
            char[] chars = str.toCharArray();

            // Sort characters
            Arrays.sort(chars);

            // Sorted characters become the key
            String key = new String(chars);

            // Add string to its anagram group
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}