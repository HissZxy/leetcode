import java.util.*;

public class Count2 {
    public int countNumberOf2s(int n) {
        int count = 0,i;
        if(n < 2)return 0;
        else if(n < 10)return 1;
        else
            for(int j = 2;j < n;j++) {
                 i = j;
                while(i > 0){
                    if(i%10 == 2)
                        count ++;
                        i/=10;
                    if(i == 0)
                        break;
                }
            }
        return count;
    }
}