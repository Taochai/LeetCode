import java.util.HashMap;
import java.util.Map;

public class Leetcode12IntegertoRoman {
    Map<Integer,String> map = new HashMap<>();
    public String intToRoman(int num) {
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");
        map.put(4,"IV");
        map.put(9,"IX");
        map.put(40,"XL");
        map.put(90,"XC");
        map.put(400,"CD");
        map.put(900,"CM");
        map.put(0,"");
        StringBuilder ans = new StringBuilder();
        int[] arr = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        for(int i=0;i<arr.length;i++){
            int quo = num/arr[i];
            for(int j=0;j<quo;j++){
                ans.append(map.get(arr[i]));
            }
            num = num%arr[i];
        }
        return ans.toString();
    }
}
