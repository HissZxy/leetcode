import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
            String str = sc.nextLine();
            int len = str.length();
            String[] s=str.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = s.length-1; i >=0; i--) {
                sb.append(s[i]+" ");
            }
             
            System.out.println(sb.substring(0, len));
    }
    }
}