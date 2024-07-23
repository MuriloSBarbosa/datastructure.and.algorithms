package murilo.barbosa.hashtable.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringConcatenation {

    public static void main(String[] args) {
        findSubstring("barfoothefoobarman",
              new String[]{"foo","bar"});

    }

    // barfoothefoobarman
    // ["foo","bar"]
    public static List<Integer> findSubstring(String s, String[] words) {
        int slidingWindowSize = words[0].length() * words.length;

        List<Integer> indexes = new ArrayList<>();

        String currentPattern = "";

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            currentPattern += s.charAt(i);

            if (i >= slidingWindowSize) {
                currentPattern = currentPattern.substring(1);
            }

            if (i >= slidingWindowSize - 1) {
                String[] array = getGroupOf(currentPattern, words[0].length());
                Map<String, Integer> currentWordCount = new HashMap<>();

                for (String word : array) {
                    currentWordCount.put(word, currentWordCount.getOrDefault(word, 0) + 1);
                }

                if(currentWordCount.equals(wordCount)) {
                    indexes.add(i - slidingWindowSize + 1);
                }

            }
        }

        return indexes;
    }

    public static String[] getGroupOf(String s, int num) {
        String[] result = new String[s.length() / num];
        int count = 0;
        for (int i = 0; i < s.length(); i += num) {
            result[count++] = s.substring(i, Math.min(s.length(), i + num));
        }

        return result;
    }
}
