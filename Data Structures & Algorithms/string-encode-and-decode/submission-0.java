
class Solution {

    // Encode list to single string
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    // Decode string back to list
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {

            // find '#'
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            // length of string
            int length = Integer.parseInt(str.substring(i, j));

            // move to actual string start
            j++;

            // extract string
            String word = str.substring(j, j + length);
            result.add(word);

            // move pointer
            i = j + length;
        }

        return result;
    }
}