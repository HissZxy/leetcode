
import java.util.*;
 
public class Exchange {
    public int[] exchangeAB(int[] AB) {
        // write code here
         
        AB[0]=AB[0]+AB[1];
        AB[1]=AB[0]-2*AB[1];
        AB[0]=(AB[0]-AB[1])/2;
        AB[1]=AB[0]+AB[1];
        return AB;
         
    }
}