import java.util.ArrayList;
import java.util.List;
/*

 */
public class Leetcode46Permutations {
    List<List<Integer>> L = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(nums,new ArrayList<Integer>());
        return L;
    }
    public void helper(int[] nums, List<Integer> tmpL){
        //end condition
        if(tmpL.size()==nums.length){
            L.add(new ArrayList<>(tmpL));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(tmpL.contains(nums[i])) continue;
            tmpL.add(nums[i]);
            helper(nums,tmpL);
            tmpL.remove(tmpL.size()-1);
        }
    }
}
