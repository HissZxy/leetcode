import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        String[] list=line.split(" ");
        for(int i=list.length-1;i>0;i--){
            System.out.print(list[i]+" ");
        }
        System.out.print(list[0]);
    }
}