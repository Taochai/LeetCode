package cisco;

import java.util.HashMap;
import java.util.Map;

public class MeanMode {
    public static void main(String[] args) {
//        meanAndMode(new int[]{4,7,1,3,7,7,7});
        meanAndMode(new int[]{-2,-3,-2,2,3,4});
    }

    public static void meanAndMode(int[] arr){
        int[] ans = new int[2];
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : arr){
            sum += n;
            if(map.containsKey(n)){
                map.put(n,map.get(n)+1);
            }else{
                map.put(n,1);
            }
        }
        double mean =Math.round((double)sum/arr.length*10000)/10000.0;
        int max = Integer.MIN_VALUE;
        int mode = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()>max){
                max = entry.getValue();
                mode = entry.getKey();
            }
            else if(entry.getValue()==max){
                mode = Math.min(mode,entry.getKey());
            }
        }
        System.out.println(mean);
        System.out.println(mode);
    }
}
