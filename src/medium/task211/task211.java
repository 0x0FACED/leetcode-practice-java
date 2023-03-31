// Using Trie Structure

class WordDictionary {
    Trie dictionary;

    public WordDictionary() {
        dictionary = new Trie();
    }
    
    public void addWord(String word) {
        dictionary.insert(word);
    }
    
    public boolean search(String word) {
        return dictionary.search(word);
    }

    private class Trie {

        private static class Node{
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
            return dfs(0, curr, word);
        }

        private boolean dfs(int index, Node curr, String word) {
            for(int i = index; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(ch == '.') {
                for(Node child : curr.children) {
                    if(child != null && dfs(i + 1, child, word)){
                        return true;
                    } 
                }
                return false;
                } else {
                    int childIdx = word.charAt(i) - 'a';
                    if(curr.children[childIdx] == null){
                        return false;
                    } 
                    curr = curr.children[childIdx];
                }
            }
            return curr.isEndOfWord;
	    }   
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
