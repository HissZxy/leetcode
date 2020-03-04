import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] js = new int[3];
        int jf = 0;
        int[] ys = new int[3];
        int yf = 0;
        int p = 0;
        while(N--!=0){
            int j = convert(in.next());
            int y = convert(in.next());
            if(j==y)
                p++;
            else if(judge(j, y)){
                //¼×Ó®
                js[j]++;
                yf++;
            }else{
                ys[y]++;
                jf++;
            }
        }
        System.out.println(yf+" "+p+" "+jf);
        System.out.println(jf+" "+p+" "+yf);
        System.out.println(getResult(js)+" "+getResult(ys));
    }
     
    private static int convert(String s){
        if(s.equals("B"))
            return 0;
        if(s.equals("C"))
            return 1;
        return 2;// J
    }
    private static boolean judge(int j,int y){
        if(j==2&&y==0)
            return true;
        else if(j>y)
            return false;
        return true;
    }
    private static String getResult(int[] a){
        int max = a[0];
        int index = 0;
        for(int i = 1;i<a.length;i++){
            if(a[i]>max){
                max = a[i];
                index = i;
            }
        }
        return index==0?"B":index==1?"C":"J";
    }
}