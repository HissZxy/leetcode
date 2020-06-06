import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int y1,y2,y3,y4;
        float a,b,c;
        while (in.hasNextInt()) {
            y1 = in.nextInt();
            y2 = in.nextInt();
            y3 = in.nextInt();
            y4 = in.nextInt();
            a=(y1+y3)/2f;
            b=(y3-y1)/2f;
            c=(y4-y2)/2f;
            if((a-((y1+y3)/2))!=0){
                System.out.print("No");
                return ;
            }
            if((b-((y3-y1)/2)!=0)||(b!=((y2+y4)/2))){
                System.out.print("No");
                return ;
            }
            if((c-((y4-y2)/2))!=0){
                System.out.print("No");
            return ;
            }
            //满足所有的约束条件，输出解。
            System.out.print((int)a+" "+(int)b+" "+(int)c);
            }
    }
}