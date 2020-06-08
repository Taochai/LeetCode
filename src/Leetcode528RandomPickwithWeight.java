import java.util.Arrays;
import java.util.Random;

/*
    [1,5,3] --> [1,6,9]
    random number in[1,9];
    1 -->  return 0;
    2 -->  1;
    3 -->  1;
    ...
    6 -->  1;
    7 -->  2;
    8 -->  2;
    实现按比例得随机数
 */
public class Leetcode528RandomPickwithWeight {
    class Solution {
        int[] arr;
        public Solution(int[] w) {
            this.arr = new int[w.length];
            for(int i=0;i<w.length;i++){
                if(i==0){
                    arr[0] = w[0];
                    continue;
                }
                arr[i]=arr[i-1]+w[i];
            }
        }

        public int pickIndex() {
            Random rand = new Random();
            int x = rand.nextInt(arr[arr.length-1])+1;
            int pos = Arrays.binarySearch(arr,x);
            if(pos<0) pos = -pos-1;
            return pos;
        }
    }

}
