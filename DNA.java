import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int i,j,n = input.length();
        for(i=1;i<=n;i++){
            HashSet<String> set= new HashSet<String>();
            for(j=0;j<n-i;j++) set.add(input.substring(j,j+i));
            if(set.size()<Math.pow(4,i)){
                System.out.println(i);
                break;
            }
        }
         
    }
}