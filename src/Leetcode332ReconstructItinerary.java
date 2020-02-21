import java.util.*;
//1st time dfs 一个节点一个节点往下找， end case是ans的list里的数达到要求的n停止就行。 这他妈也算DFS的题？
//用欧拉回路也能做。但是我没做，看了概念没对上，真他妈狗。
public class Leetcode332ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        //用map存，然后按顺序查找，一直找到map里没有的string返回.
        List<String> ans = new ArrayList<>();
        ans.add("JFK");
        Map<String,List<String>> map = new HashMap<>();
        for(List<String> ticket : tickets){
            if(!map.containsKey(ticket.get(0))){
                map.put(ticket.get(0),new ArrayList<String>());
            }
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        for(List<String> l : map.values()){
            Collections.sort(l);
        }
        int n = tickets.size() + 1;
        dfs(ans,map,n,"JFK");
        return ans;
    }
    private boolean dfs(List<String> ans, Map<String, List<String>> map, int n, String currStr){
        if(ans.size() == n) return true;
        if(!map.containsKey(currStr)) return false;
        List<String> dest = map.get(currStr);
        for(int i=0; i<dest.size();i++){
            String nextStr = dest.get(i);
            dest.remove(i);
            ans.add(nextStr);
            if(dfs(ans,map,n,nextStr)) return true;
            dest.add(i,nextStr);
            ans.remove(ans.size()-1);
        }
        return false;
    }
}
