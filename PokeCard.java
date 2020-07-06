import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[][] f = new int[n][n];
        int[][] s = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = a[i];
            s[i][i] = 0;
        }
        for (int d = 1; d < n; d++) {
            for (int i = 0; i < n - d; i++) {
                f[i][i + d] = Math.max(a[i] + s[i + 1][i + d], a[i + d] + s[i][i + d - 1]);
                s[i][i + d] = Math.min(f[i + 1][i + d], f[i][i + d -1]);
            }
        }
        System.out.println(Math.max(f[0][n-1], s[0][n-1]));
    }
}