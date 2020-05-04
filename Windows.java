import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if(num==null||size<0){
            return null;
        }
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(size==0){
            return list;
        }
        ArrayList<Integer> temp=null;
        int length=num.length;
        if(length<size){
            return list;
        }else{
            for(int i=0;i<length-size+1;i++){
                temp=new ArrayList<Integer>();
                for(int j=i;j<size+i;j++){
                    temp.add(num[j]);
                }
                Collections.sort(temp);
                list.add(temp.get(temp.size()-1));
            }
        }
        return list;
    }
}