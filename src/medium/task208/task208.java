class Trie {

    public static class Node{
        char ch;
        Node[] children;
        boolean isEndOfWord;
        public Node(){}
        public Node(char data){
            this.ch = data;
            this.children = new Node[26];
            isEndOfWord = false;
        }
    }

    Node root;
    public Trie() {
        root = new Node('/');
    }

    public void insert(String word) {
        Node curr = root;
        int childIndex = 0;
        for (char ch : word.toCharArray()){
            childIndex = ch - 'a';
            if(curr.children[childIndex] == null){
                curr.children[childIndex] = new Node(ch);
            }
            curr = curr.children[childIndex];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        Node curr = root;
        int childIndex = 0;
        for (char ch : word.toCharArray()){
            childIndex = ch - 'a';
            if(curr.children[childIndex] == null){
                return false;
            }
            curr = curr.children[childIndex];
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        int childIndex = 0;
        for (char ch : prefix.toCharArray()){
            childIndex = ch - 'a';
            if(curr.children[childIndex] == null){
                return false;
            }
            curr = curr.children[childIndex];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
