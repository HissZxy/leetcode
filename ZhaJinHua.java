import java.util.*;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.*;
public class Main {
    private static int[] B = new int[20000];
    private static int[] A = new int[20000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String L = sc.nextLine();
            String[] line = L.split(" ");
            Arrays.sort(A);
            Arrays.sort(B);
            int scoreA = getScore(A);
            int scoreB = getScore(B);
            System.out.println(scoreA > scoreB ? 1 : -1);
        }
    }


    private static int getScore(int[] A) {
        int j = 0;
        int k = 0;
        j = A[0] + A[1] + A[2];
        k = B[0] + B[1] + B[2];
        if (j < k) {
            System.out.print(k);
        } else if (j > k) {
            System.out.print(j);
        } else {
            System.out.print("和");
        }

        return 0;
    }
}