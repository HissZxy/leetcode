import java.util.*;
public class Gift {
    public int getValue(int[] gifts, int n) {
        // write code here
        int money=0;
        TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            if(n>1){
                if(map.get(gifts[i])==null)
                    map.put(gifts[i],1);
                else{
                    int number=map.get(gifts[i]).intValue();
                    number++;
                    if(number>n/2)
                        return money=gifts[i];
                    map.put(gifts[i],number);
                }
            }
        }
        return money;
    }
}