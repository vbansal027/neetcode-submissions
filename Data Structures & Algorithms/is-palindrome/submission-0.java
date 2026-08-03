class Solution {

    private boolean isAlphaNumeric(char c) {
        return ('0' <= c && c <= '9') || ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

    public boolean isPalindrome(String s) {
        
        int n = s.length();
        int i = 0;
        int j = n-1;

        while (i < j) {
            if (!isAlphaNumeric(s.charAt(i))) {
                i++;
                continue;
            }
            if (!isAlphaNumeric(s.charAt(j))) {
                j--;
                continue;
            }
            
            char x = Character.toLowerCase(s.charAt(i));
            char y = Character.toLowerCase(s.charAt(j));
            if (x == y) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}