import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            int c = scanner.nextInt();
            int k = scanner.nextInt();
            yusefu(t,c,k);
            scanner.close();
        }

    public static void yusefu(int t,int c,int k) {
      List<Integer> start = new ArrayList<Integer>();
        for (int i = 1; i <= t; i++) {
            start.add(i);
        }

        while (start.size() > 0) {
            k = k +1  ;
            k = k % (start.size()) - 1;
            if (k < 0) {
                System.out.println(k);
                start.remove(start.size() - 1);
                k = 0;
            } else {
                System.out.println(start.get(k));
                start.remove(k);
            }
        }
    }
}
