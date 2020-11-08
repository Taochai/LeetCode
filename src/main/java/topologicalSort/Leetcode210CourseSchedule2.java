package topologicalSort;

import java.util.ArrayList;
import java.util.List;

public class Leetcode210CourseSchedule2 {
    List<Integer> order = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            graph.get(pre).add(course);
        }
        int[] state = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!dfs(i,state,graph)) return new int[0];
        }
        int[] ans = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            ans[i] = order.get(i);
        }
        return ans;
    }
    public boolean dfs(int curr,int[] state,  ArrayList<ArrayList<Integer>> graph){
        if(state[curr]==2) return true;
        if(state[curr]==1) return false;  //circle exists
        state[curr] = 1;
        for(int i : graph.get(curr)){
            if(!dfs(i, state, graph)) return false;
        }
        state[curr] = 2;
        this.order.add(0,curr);
        return true;
    }
}
