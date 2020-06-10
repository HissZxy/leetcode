import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N=in.nextInt();
        int a=0,b=1;
        while(b<=N){
            int b_temp=b+a;
            a=b;
            b=b_temp;
        }
        System.out.print((b-N)>(N-a)?N-a:b-N);
    }
}