package robinhood;

import java.util.HashSet;
import java.util.Set;
//找到所有的整数组合
public class divideByThree {
    public static void main(String[] args) {
        Set<Integer> set = func("456");
        for(int n : set){
            System.out.println(n);
        }
    }
    public static Set<Integer> func(String s){
        char[] charArr = s.toCharArray();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<charArr.length;i++){
            dfs(i,"",charArr,set);
        }
        return set;
    }
    public static void dfs(int index,String str,char[] charArr, Set<Integer> set){
        str += charArr[index];
        set.add(Integer.parseInt(str));
        if(index==charArr.length-1) return;
        dfs(index+1,str,charArr,set);
        str = str.substring(0,str.length()-1);
    }
}
