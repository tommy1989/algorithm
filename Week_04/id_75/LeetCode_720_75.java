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
    
    //��Trie����д���ַ���
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
    
    //��Trie����Ѱ����ĵ���
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
    
    //��Trie���в���һ���ַ���
    private boolean find(char[] pattern){
        TrieNode p = root;
        for(int i = 0; i < pattern.length; i++){
            int index = pattern[i] - 'a';
            if(p.children[index] == null){
                return false;//������pattern
            }
            p = p.children[index];
        }
        if(p.isEndingChar == false) return false; //������ȫƥ�䣬ֻ��ǰ׺
        else return true;
    }
    //Trie���ڵ�
    private class TrieNode{
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;
        
        public TrieNode(char data) {
            this.data = data;
        }
        
    }
}