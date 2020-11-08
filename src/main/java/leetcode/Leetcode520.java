package leetcode;

public class Leetcode520 {
    public boolean detectCapitalUse(String word) {
        if(word.length()==1) return true;
        char[] words = word.toCharArray();
        if(words[0]-'a'<0){
            if(words[1]-'a'<0){
                for(int i=2;i<words.length;i++){
                    if(words[i]-'a'>=0) return false;
                }
                return true;
            }
            else if(words[1]-'a'>=0){
                for(int i=2;i<words.length;i++){
                    if(words[i]-'a'<0) return false;
                }
                return true;
            }
        }else{
            for(int i=1;i<words.length;i++){
                if(words[i]-'a'<0) return false;
            }
            return true;
        }
        return false;
    }
}
