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

    public List<List<Integer>> findAllSubsetsWhoseSumIsK(int[] arr, int target) {
        List<List<Integer>> list = new ArrayList<>();
        findAllSubsetsWhoseSumIsKHelper(0, 0, target, arr, new ArrayList<>(), list);
        return list;
    }

    private void findAllSubsetsWhoseSumIsKHelper(int i, int sum, int target, int[] arr, List<Integer> subset, List<List<Integer>> subsetsList) {
        if (i == arr.length) {
            return;
        }



        if (sum + arr[i] < target) {
            subset.add(arr[i]);
            findAllSubsetsWhoseSumIsKHelper(i + 1, sum + arr[i], target, arr, subset, subsetsList);
            subset.remove(subset.size() - 1);
            findAllSubsetsWhoseSumIsKHelper(i + 1, sum, target, arr, subset, subsetsList);

        } else if (sum + arr[i] > target) {
            findAllSubsetsWhoseSumIsKHelper(i + 1, sum, target, arr, subset, subsetsList);
        } else {
            subset.add(arr[i]);
            subsetsList.add(new ArrayList<>(subset));
            subset.remove(subset.size() - 1);
            findAllSubsetsWhoseSumIsKHelper(i + 1, sum, target, arr, subset, subsetsList);
        }
    }

    public String[] getCode(String input) {
        // This method generates all possible character encodings for a given input string.
        // It uses a helper method to perform a recursive backtracking approach.

        List<String> list = new ArrayList<>(); // List to store all possible encodings.
        var sb = new StringBuffer(); // StringBuffer to build the current encoding.
        getCodesHelper(input, sb, list); // Call helper method to populate the list with encodings.

        var result = new String[list.size()]; // Create a result array of the same size as the list.
        var i = 0;
        for (String str : list) {
            result[i++] = str; // Transfer each encoding from the list into the result array.
        }

        return result; // Return the array of encoded strings.
    }

    private void getCodesHelper(String input, StringBuffer sb, List<String> list) {
        // Base case: if the input is empty, add the current encoding (sb) to the list.
        if (input.length() == 0) {
            list.add(new String(sb.toString()));
            return;
        }

        // Process the first character as a single digit.
        char c1 = (char)(input.charAt(0) - '0' + 'a' - 1); // Convert the first character into a letter.
        sb.append(c1); // Add the converted character to the current encoding.
        getCodesHelper(input.substring(1), sb, list); // Recurse with the remaining input.
        sb.deleteCharAt(sb.length() - 1); // Backtrack by removing the last character.

        // Process the first two characters as a double digit, if possible.
        if (input.length() >= 2) {
            int num = Integer.parseInt(input.substring(0, 2)); // Get the first two characters as a number.
            char c2 = (char) (num - 1 + 'a'); // Convert the number into a corresponding letter.
            if (num >= 10 && num <= 26) { // Only process if the number corresponds to a valid letter.
                sb.append(c2); // Add the converted character to the current encoding.
                getCodesHelper(input.substring(2), sb, list); // Recurse with the remaining input after the first two characters.
                sb.deleteCharAt(sb.length() - 1); // Backtrack by removing the last character.
            }
        }
    }

    // permutations approach - 2
    public static String[] permutationOfString(String input){
        // Write your code here
        List<String> list = new ArrayList<>();
        backtrack(input, new StringBuffer(), list, new HashSet<>());
        var result = new String[list.size()];
        var i = 0;
        for (String str: list) {
            result[i++] = str;
        }

        return result;
    }

    private static void backtrack(String input, StringBuffer sb, List<String> list, Set<String> set) {
        if (input.length() == 0) {
            var str = sb.toString();
            if (!set.contains(str))
                list.add(new String(str));
            return;
        }

        for (char c : input.toCharArray()) {
            sb.append(c);
            int idx = input.indexOf(c);
            String newStr = input.substring(0, idx) + input.substring(idx + 1);
            backtrack(newStr, sb, list, set);
            sb.deleteCharAt(sb.length() -1);
        }

    }


}
