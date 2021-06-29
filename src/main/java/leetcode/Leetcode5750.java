package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode5750 {

    public static void main(String[] args) {
        Leetcode5750 leetcode5750 = new Leetcode5750();
        int[][] arr = {{1993, 1999}, {2000, 2010}};
        int[][] arr2 = {{1950, 1961}, {1960, 1971}, {1970, 1981}};

        System.out.println(leetcode5750.maximumPopulation(arr));
        System.out.println(leetcode5750.maximumPopulation(arr2));
    }

    public int maximumPopulation(int[][] logs) {
        int maxP = 0, maxYear = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            int start = logs[i][0];
            int end = logs[i][1];
            for (int j = start; j < end; j++) {
                if (!map.containsKey(j)) {
                    map.put(j, 0);
                }
                map.put(j, map.get(j) + 1);
                if (map.get(j) > maxP) {
                    maxYear = j;
                    maxP = map.get(j);
                }
                if (map.get(j) == maxP && j < maxYear) {
                    maxYear = j;
                }
            }
        }
        return maxYear;
    }
}
