import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int N = scan.nextInt();// 输入的人数
            if (N == 0) {// 如果检测到输入的人数为0 则结束
                return;
            }
            int[] arr = new int[N];// 保存N个人的分数
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scan.nextInt();
            }
            int T = scan.nextInt();// 目标分数 输出击中目标分数的个数
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (T == arr[i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}