

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = Integer.parseInt(str);
        sc.close();
        long count = 0;
        int a = str.length();
        int m = n;
        for (int j = 0; j < a; j++) {
            long p=(long) Math.pow(10,j);
            int b=m%10;
            m=m/10;
            if(b==0) {
                count=count+m*p;
            }else if(b==1){
                count=count+m*p+n%p+1;
            }else if (b>1) {
                count=count+(m+1)*p;
            }
        }    
        System.out.println(count);
    }
}