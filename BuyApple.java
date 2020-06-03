
import java.util.*;
public class Main{
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            System.out.println(count(n));
        }
    }
    public static int count(int n){
        if(n%2!=0||n==10||n<6) return -1;//一定是偶数（6，8都是）,最小是6，10以上偶数都可以；
        if(n%8==0) return n/8;//如果拿八个拿完最好
        return 1+n/8;//对于10以上的偶数，只要对8取余数不为0，就要从前面的1或者2个8中拿出2个，把余数补为6（本来余数就是6，就不用拿）。所以+1；
    }
}