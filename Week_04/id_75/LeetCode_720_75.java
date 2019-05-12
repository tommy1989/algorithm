class Solution {
    private String longestWord = "";
    private TrieNode root = new TrieNode('/');
    
    public String longestWord(String[] words) {
        for(String word : words){
            insert(word.toCharArray());
        }
        searchLongestWord(new StringBuilder(),root);
        return longestWord;
    }
    
    //往Trie树里写入字符串
    private void insert(char[] text){
        TrieNode p = root;
        for(int i = 0; i < text.length; i++){
            int index = text[i] - 'a';
            if(p.children[index] == null){
                TrieNode childNode = new TrieNode(text[i]);
                p.children[index] = childNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }
    
    //在Trie树中寻找最长的单词
    private void searchLongestWord(StringBuilder sb,TrieNode root){
        if(root != null){
            for(int i = 0; i < root.children.length; i++){
                TrieNode childNode = root.children[i];
                if(childNode != null && childNode.isEndingChar){
                    sb.append(childNode.data); 
                    if(sb.length() > longestWord.length()){
                        longestWord = sb.toString();
                    }
                    searchLongestWord(sb,childNode);
                    sb.deleteCharAt(sb.length() - 1);
                }  
            }
        }
    }
    
    //在Trie树中查找一个字符串
    private boolean find(char[] pattern){
        TrieNode p = root;
        for(int i = 0; i < pattern.length; i++){
            int index = pattern[i] - 'a';
            if(p.children[index] == null){
                return false;//不存在pattern
            }
            p = p.children[index];
        }
        if(p.isEndingChar == false) return false; //不能完全匹配，只是前缀
        else return true;
    }
    //Trie树节点
    private class TrieNode{
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;
        
        public TrieNode(char data) {
            this.data = data;
        }
        
    }
}