class Solution {

    private static Map<Character, String> keyMap = new HashMap();
    static {
        keyMap.put('2', "abc");
        keyMap.put('3', "def");
        keyMap.put('4', "ghi");
        keyMap.put('5', "jkl");
        keyMap.put('6', "mno");
        keyMap.put('7', "pqrs");
        keyMap.put('8', "tuv");
        keyMap.put('9', "wxyz");
        keyMap = Collections.unmodifiableMap(keyMap);
    }

    private List<String> res;

    public List<String> letterCombinations(String digits) {
        this.res = new ArrayList();
        recurse(digits, 0, new StringBuilder());
        return this.res;
    }

    private void recurse(String digits, int i, StringBuilder sb) {
        if (i == digits.length()) {
            if (!sb.isEmpty()) {
                this.res.add(sb.toString());
            }
            return;
        }

        for (Character letter : keyMap.get(digits.charAt(i)).toCharArray()) {
            sb.append(letter);
            recurse(digits, i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }
}
