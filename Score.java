import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int N = scan.nextInt();// ���������
            if (N == 0) {// �����⵽���������Ϊ0 �����
                return;
            }
            int[] arr = new int[N];// ����N���˵ķ���
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scan.nextInt();
            }
            int T = scan.nextInt();// Ŀ����� �������Ŀ������ĸ���
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