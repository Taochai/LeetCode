import java.util.Stack;

public class Leetcode1472DesignBrowserHistory {
    class BrowserHistory {
        //把forward也当成visit来处理，区别在于visit要清空forward记录，forward不清空记录.
        Stack<String> backS;
        Stack<String> forwardS;
        public BrowserHistory(String homepage) {
            backS = new Stack<>();
            forwardS = new Stack<>();
            backS.push(homepage);
        }

        public void visit(String url) {
            backS.push(url);
            forwardS=new Stack<>();
        }

        public String back(int steps) {
            if(backS.size()==1) return backS.peek();
            if(steps>=backS.size()){
                steps = backS.size()-1;
            }
            while(steps>0){
                forwardS.push(backS.pop());
                steps--;
            }
            return backS.peek();
        }

        public String forward(int steps) {
            if(forwardS.size()==0) return backS.peek();
            if(steps>forwardS.size()){
                steps = forwardS.size();
            }
            while(steps>0){
                backS.push(forwardS.pop());
                steps--;
            }
            return backS.peek();
        }
    }

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
}
