package recursion.solutions;

import java.util.*;

public class RecursionSolutions {
    public int countSteps(int n) {
        if (n == 0) return 0;

        return countSteps(n, 0);
    }

    private int countSteps(int n, int count) {
        if (n == 1) return count + 1;
        if (n % 2 == 1) return countSteps(n - 1, ++count);
        return countSteps(n/2, ++count);
    }

    public List<String> generateAllStrings(int n) {
        var sb = new StringBuffer();
        List<String> list = new ArrayList<>();
        var binaryString = "01";
        generateAllStringsHelper(0, n, sb, list, binaryString);
        return list;
    }

    private void generateAllStringsHelper(int index, int n, StringBuffer sb, List<String> list, String binaryString) {
        if (sb.length() == n) {
            list.add(sb.toString());
            return;
        }

        for (int i = index; i < n; i++) {
            for (int j = 0; j < binaryString.length(); j++) {
                sb.append(binaryString.charAt(j));
                generateAllStringsHelper(i + 1, n, sb, list, binaryString);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    static Map<Character, String> map = new HashMap<>();
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    public List<String> letterCombinations(String digits) {
        var n = digits.length();
        var sb = new StringBuffer();
        List<String> list = new ArrayList<>();
        letterCombinationsHelper(0, n, digits, sb, list);
        return list;
    }

    private void letterCombinationsHelper(int index, int n, String digits, StringBuffer sb, List<String> list) {
        if (sb.length() == n) {
            list.add(sb.toString());
            return;
        }

        for (int i = index; i < n; i++) {
            var str = map.get(digits.charAt(i));
            for (char ch: str.toCharArray()) {
                sb.append(ch);
                letterCombinationsHelper(i + 1, n, digits, sb, list);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public List<String> findAllPermutations(String str) {
        int n = str.length();
        List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        HashSet<Character> set = new HashSet<>();
        findAllPermutationsHelper(str, set, sb, list);
        return list;
    }

    private void findAllPermutationsHelper(String str, HashSet<Character> set, StringBuffer sb, List<String> list) {
        // Base case: if the StringBuffer length matches the input string length
        if (sb.length() == str.length()) {
            list.add(sb.toString());
            return;
        }

        // Loop through all characters in the string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Skip the character if it is already used
            if (set.contains(ch)) continue;

            // Add the character to the StringBuffer and the set
            sb.append(ch);
            set.add(ch);

            // Recur to continue building the permutation
            findAllPermutationsHelper(str, set, sb, list);

            // Backtrack: remove the character from the set and the StringBuffer
            set.remove(ch);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


}
