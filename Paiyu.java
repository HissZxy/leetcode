import java.util.Arrays;
import java.util.Scanner;

public class Paiyu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] arr1 = new int[n];
        for(int i = 0;i < n ; i++){
            arr[i] = sc.nextInt();
            arr1[i] = arr[i];
        }
        Arrays.sort(arr1);
        int count = 0;
        int j = 0;
        for(int i = 0;i<n;i++){
            if(arr[i] == arr1[j]){
                count ++;
                j++;
            }
        }
        System.out.println(n - count);
        }
}
