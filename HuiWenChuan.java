import java.util.*;
public class Main{
    public static void main(String as[]){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
           String s=in.next();
           System.out.println(getAns(s.toCharArray(),0,s.length()-1,false)?"YES":"NO");
        }
    }
    private static boolean getAns(char[] a,int start,int end,boolean flag){
        if(end<=start){
            return true;
        }
        if(a[start]==a[end]){
            return getAns(a,start+1,end-1,flag);
        }
        else{
           if(flag){
               return false;
           }
           return getAns(a,start,end-1,true)||getAns(a,start+1,end,true);
        }
    }
}