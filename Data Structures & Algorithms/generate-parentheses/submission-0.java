class Solution {

    private List<String> res;
    private int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        this.res = new ArrayList<String>();
        recurse(new StringBuilder(), 0, 0);
        return this.res;
    }

    private void recurse(StringBuilder sb, int open, int used) {

        if (sb.length() == (2 * this.n)) {
            this.res.add(sb.toString());
            return;
        }

        if (used < this.n) {
            sb.append('(');
            recurse(sb, open+1, used+1);
            sb.deleteCharAt(sb.length()-1);
        }

        if (open > 0) {
            sb.append(')');
            recurse(sb, open-1, used);
            sb.deleteCharAt(sb.length()-1);
        }

        return;
    }
}
