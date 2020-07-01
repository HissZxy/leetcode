import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            if (String.valueOf(n * n).endsWith( String.valueOf(n))) 
                System.out.println("Yes!");
            else 
                System.out.println("No!");
        }
    }
}
