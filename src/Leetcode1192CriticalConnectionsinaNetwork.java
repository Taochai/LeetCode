import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
1st 不太会写。
*/
public class Leetcode1192CriticalConnectionsinaNetwork {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //initial graph
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (List<Integer> connection : connections) {
            int v = connection.get(0);
            int w = connection.get(1);

            graph.get(v).add(w);
            graph.get(w).add(v);
        }
        int[] jump = new int[graph.size()];
        for(int i=0;i<jump.length;i++){
            jump[i]=-1;
        }

        List<List<Integer>> ans = new ArrayList<>();
        dfs(0,-1,0,jump,ans,graph);
        return ans;
    }
    public int dfs(int v, int par, int lvl, int[] jump,List<List<Integer>> ans,Map<Integer,List<Integer>> g){
        jump[v] = lvl+1;
        for(int child : g.get(v)){
            if(child==par) continue;
            else if(jump[child]==-1){
                jump[v] = Math.min(jump[v],dfs(child,v,lvl+1,jump,ans,g));
            }
            else{
                jump[v] = Math.min(jump[v],jump[child]);
            }

        }
        if(jump[v]==lvl+1 && par!=-1){
            List<Integer> tmpL = new ArrayList<>();
            tmpL.add(v);
            tmpL.add(par);
            ans.add(tmpL);
        }
        return jump[v];
    }
}
