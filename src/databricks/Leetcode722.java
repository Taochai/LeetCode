package databricks;

import java.util.ArrayList;
import java.util.List;

public class Leetcode722 {

        public List<String> removeComments(String[] source) {
            boolean block = false;
            List<String> ans = new ArrayList<>();
            StringBuilder newLine = new StringBuilder();
            for(String s : source){
                if(!block) newLine = new StringBuilder();
                for(int i=0;i<s.length();i++){
                    if(!block && i+1<s.length() && s.charAt(i)=='/'&&s.charAt(i+1)=='*'){
                        block = true;
                        i++;
                    }
                    else if(block && i+1<s.length() && s.charAt(i)=='*'&&s.charAt(i+1)=='/'){
                        block = false;
                        i++;
                    }
                    else if(!block && i+1<s.length() && s.charAt(i)=='/'&&s.charAt(i+1)=='/'){
                        i++;
                        break;
                    }
                    else if(!block){
                        newLine.append(s.charAt(i));
                    }
                }
                if(!block && newLine.length()>0){
                    ans.add(newLine.toString());
                }
            }
            return ans;
        }

}
