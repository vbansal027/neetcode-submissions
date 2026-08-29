class PrefixTree {

    TreeNode root;

    public PrefixTree() {
        this.root = new TreeNode();
    }

    public void insert(String word) {
        insertFrom(this.root, 0, word);
        return;
    }

    public boolean search(String word) {
        return isPresent(this.root, 0, word);
    }

    public boolean startsWith(String prefix) {
        return startsWith(this.root, 0, prefix);
    }

    private void insertFrom(TreeNode root, int i, String word) {
        if (i < word.length()) {
            
            // create child node if not already present
            if (!root.subTrees.containsKey(word.charAt(i))) {
                root.subTrees.put(word.charAt(i), new TreeNode());
            }

            // if this is the last letter of the word, mark the boolean and return
            if (i == word.length()-1) {
                root.subTrees.get(word.charAt(i)).isWord = true;
            } else {    // else recurse to the next letter and then return
                insertFrom(root.subTrees.get(word.charAt(i)), i+1, word);
            }
            return;
        }
    }

    private boolean isPresent(TreeNode root, int i, String word) {
        if (i >= word.length()) {
            return true;
        }

        Character c = word.charAt(i);
        TreeNode jumpNode = root.subTrees.get(c);
        
        // if no path exists of if the path exists but is not a word return false
        if (
            (null == jumpNode) ||
            (i == word.length()-1 && (!jumpNode.isWord))
        ) {
            return false;
        }

        // recruse to next letter
        return isPresent(jumpNode, i+1, word);
    }

    private boolean startsWith(TreeNode root, int i, String prefix) {
        if (i >= prefix.length()) {
            return true;
        }

        Character c = prefix.charAt(i);
        TreeNode jumpNode = root.subTrees.get(c);
        
        // if no path exists of if the path exists but is not a prefix return false
        if (null == jumpNode){
            return false;
        }

        // recruse to next letter
        return startsWith(jumpNode, i+1, prefix);
    }

    private class TreeNode {
        boolean isWord;
        Map<Character, TreeNode> subTrees;

        TreeNode() {
            this.isWord = false;
            this.subTrees = new HashMap();
        }

        TreeNode(boolean isWord) {
            this.isWord = isWord;
            this.subTrees = new HashMap();
        }
    }

}
