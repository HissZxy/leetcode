import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int size=input.nextInt();
        char c=input.next().charAt(0);
        char[][] arr=new char[size/2+size%2][size];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
 
                arr[i][j]=c;
            }
        }
        for(int i=1;i<arr.length-1;i++){
            for(int j=1;j<arr[i].length-1;j++){
                arr[i][j]=' ';
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}