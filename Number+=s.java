import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
            ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=i+1;j<array.length;j++){
                if(array[i] + array[j] == sum){
                    list.add(array[i]);
                    list.add(array[j]);
                    list.add(array[i] * array[j]);
                }
            }
            if(!list.isEmpty())
                lists.add(list);
        }
        if(lists.size() ==0) return new ArrayList<Integer>();
        //if(lists.size() ==1) return lists.get(0);
        Collections.sort(lists, new Comparator<ArrayList<Integer>>() {
 
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    return o1.get(2).compareTo(o2.get(2));
                 
            }
        });
         
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> temp = lists.get(0);
        for(int i=0;i<temp.size() -1;i++){
            result.add(temp.get(i));
        }
         
        return result;
    }
}