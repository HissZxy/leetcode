import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //int 可以表示的最大数 2147483647
        //1600000000 可以表示
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int i = scanner.nextInt();
            int j =i*i;
            int sum1=0;
            while (i>0){
                sum1+= i%10;
                i=i/10;
            }
            int sum2=0;
            while (j>0){
                sum2+= j%10;
                j=j/10;
            }
            System.out.println(sum1+" "+sum2);
        }
    }
}
