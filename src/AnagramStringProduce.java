public class AnagramStringProduce {
    public static void main(String[] args) {
        String s = "abc";
        dfs(s.length(),s,"");
    }
    private static void dfs(int n, String s, String currStr){
        if(currStr.length()==s.length()){
            System.out.println(currStr);
            return;
        }
        for(int i=0;i<s.length();i++){
            if(currStr.contains(Character.toString(s.charAt(i)))) continue;
            dfs(n,s,currStr + s.charAt(i));
        }
    }
}
/*
  "" --> "a" i=0, i=1,2
  "a" -->"ab" i=1 i=2
 */