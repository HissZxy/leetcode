import java.util.Arrays;
import java.util.Scanner;

public class hate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int leve = 1;
        int[] prince = new int[count];
        for(int i = 0; i<count;i++) {
            prince[i] = sc.nextInt();
        }
        Arrays.sort(prince);
        for(int j = 1;j <count;j++){
            if(prince[j-1]<prince[j]){
                leve++;
            }
            if(leve == 3){
                System.out.print(prince[j]);
                break;
            }
        }
    if(leve<3){
        System.out.println(-1);
    }
    }
}

