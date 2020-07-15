import java.util.Scanner;
public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String pattern = "[" + s2 + "]";
            String result = s1.replaceAll(pattern, "");
            System.out.println(result);
        }
    }
}