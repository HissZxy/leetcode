
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) {
 
        Scanner cin = new Scanner(System.in);
 
        ArrayList<Integer> list = new ArrayList<>();
        while(cin.hasNextInt()){
            list.add(cin.nextInt());
        }
         
        Collections.sort(list);
         
        System.out.println(list.get(list.size()/2-1));
         
    }
}