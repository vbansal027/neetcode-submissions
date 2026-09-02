class WordDictionary {

    TreeNode root;

    public WordDictionary() {
        this.root = new TreeNode();
    }

    public void addWord(String word) {
        addWord(this.root, 0, word);
    }

    private void addWord(TreeNode root, int i, String word) {
        if (i < word.length()) {
            Character l = word.charAt(i);

            TreeNode next = root.subTrees.computeIfAbsent(l, (k -> new TreeNode()));
            next.isWord |= (i == word.length()-1);
            root.subTrees.put(l, next);

            addWord(next, i+1, word);
        }
        return;
    }
    public boolean search(String word) {
        return search(this.root, 0, word);
    }

    private boolean search(TreeNode root, int i, String word) {
        if (i < word.length()) {
            Character l = word.charAt(i);
            // System.out.println(l);
            if (Character.valueOf('.').equals(l)) {
                for (Map.Entry<Character, TreeNode> entry : root.subTrees.entrySet()) {
                    // System.out.println("encountered '.', checking with key: " + entry.getKey());
                    if (search(entry.getValue(), i+1, word)) {
                        return (i == word.length()-1) ? entry.getValue().isWord : true;
                    }
                }
                return false;
            } else {
                if (!root.subTrees.containsKey(l)) {
                    // System.out.println(l + " does not exist in tree, exiting with false");
                    return false;
                } else {
                    // System.out.println("found " + l + " calling for next char");
                    if (search(root.subTrees.get(l), i+1, word)) {
                        return (i == word.length()-1) ? root.subTrees.get(l).isWord : true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private class TreeNode {
        boolean isWord;
        Map<Character, TreeNode> subTrees;

        TreeNode() {
            this.isWord = false;
            this.subTrees = new HashMap<Character, TreeNode>();
        }

        TreeNode(boolean isWord) {
            this.isWord = isWord;
            this.subTrees = new HashMap<Character, TreeNode>();
        }
    }
}
