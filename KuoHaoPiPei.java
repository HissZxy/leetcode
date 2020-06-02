import java.util.*;

public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
  Stack<Character> lefts = new Stack<Character>();
        if(A == null || A.length() != n){
            return false;
        }
        for(int i = 0; i < n; i++){
            if(A.charAt(i) == '('){
                lefts.push(A.charAt(i));
            }else if(A.charAt(i) == ')'){
                if(lefts.empty()){
                    return false;
                }else{
                    lefts.pop();
                }
            }else{
                return false;
            }
        }
        if(!lefts.empty()){
            return false;
        }else{
            return true;
        }
    }
}