import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] record = new int[n];
        for (int i = 0; i < n; i++) {
            record[i]=scanner.nextInt();
        }
        int search = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            if (record[i]==search){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}