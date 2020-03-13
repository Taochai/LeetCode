import java.util.*;
//1st time.两种成功的情况。
public class Leetcode659SplitArrayintoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        HashMap<Integer,Integer> need = new HashMap<>();
        for(int i : nums)  freq.put(i,freq.getOrDefault(i,0)+1);
        for(int i : nums){
            if(freq.get(i)==0) continue;
            else if(need.getOrDefault(i,0)>0){
                need.put(i,need.get(i)-1);
                need.put(i+1,need.getOrDefault(i+1,0)+1);
            }
            else if(freq.getOrDefault(i+1,0)>0 && freq.getOrDefault(i+2,0)>0){
                freq.put(i+1,freq.get(i+1)-1);
                freq.put(i+2,freq.get(i+2)-1);
                need.put(i+3,need.getOrDefault(i+3,0)+1);
            }else{
                return false;
            }
            freq.put(i,freq.get(i)-1);
        }
        return true;
    }
}
