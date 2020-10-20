package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode212 {
    List<String> ans = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        Node root = buildTree(words);
        List<String> res = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                find(board, i, j, res, root);
            }
        }
        return res;
    }
    private void find(char[][] b, int i, int j, List<String> res, Node node){

        if(i<0 || i>=b.length || j<0 || j>=b[0].length || b[i][j]=='.') return;
        Node next = node.next[b[i][j]-'a'];
        if(next==null) return;
        if(next.word!=null){
            res.add(next.word);
            next.word=null;
        }
        char c = b[i][j];
        b[i][j] = '.';
        find(b,i+1,j,res,next);
        find(b,i-1,j,res,next);
        find(b,i,j+1,res,next);
        find(b,i,j-1,res,next);
        b[i][j] = c;

    }
    private Node buildTree(String[] words){
        Node root = new Node();
        for(String word: words){
            Node curr = root;
            for(char c : word.toCharArray()){
                if(curr.next[c-'a']==null){
                    curr.next[c-'a'] = new Node();
                }
                curr = curr.next[c-'a'];
            }
            curr.word = word;
        }
        return root;
    }
    private static class Node{
        Node[] next = new Node[26];
        String word;
    }
}
