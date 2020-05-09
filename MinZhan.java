import java.util.Stack;
import java.util.Iterator;
 
public class Solution {
 
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int node) {
        stack.push(node);
    }
 
    public void pop() {
        stack.pop();
    }
 
    public int top() {
        return stack.peek();
    }
 
    public int min() {
        int min = stack.peek();
        int tmp = 0;
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()){
            tmp = iterator.next();
            if (min>tmp){
                min = tmp;
            }
        }
        return min;
    }
}