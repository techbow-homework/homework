//redo
//
public String frequencySort(String s) {

        if (s == null || s.isEmpty()) return s;

        // Create a sorted Array of chars.
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        // Convert identical chars into single Strings.
        List<String> charStrings = new ArrayList<String>();
        StringBuilder currentString = new StringBuilder();
        currentString.append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
        if (chars[i] != chars[i - 1]) {
        charStrings.add(currentString.toString());
        currentString = new StringBuilder();
        }
        currentString.append(chars[i]);
        }
        charStrings.add(currentString.toString());

        // Our comparator is (a, b) -> b.length() - a.length().
        // If a is longer than b, then a negative number will be returned
        // telling the sort algorithm to place a first. Otherwise, a positive
        // number will be returned, telling it to place a second.
        // This results in a longest to shortest sorted list of the strings.
        Collections.sort(charStrings, (a, b) -> b.length() - a.length());

        // Use StringBuilder to build the String to return.
        StringBuilder sb = new StringBuilder();
        for (String str : charStrings) sb.append(str);
        return sb.toString();
        }