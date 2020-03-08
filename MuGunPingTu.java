import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> ls= new ArrayList<>();
        for (int i=0;i<n;i++){
            int op = sc.nextInt();
            int length = sc.nextInt();
            if (op==1){
                ls.add(length);
            }else{
                int idx = ls.indexOf(length);
                ls.remove(idx);
            }
            if (ls.size() < 3){
                System.out.println("No");
            }else{
                Collections.sort(ls,Collections.reverseOrder());
                int max = ls.get(0);
                int sum = 0;
                for (int j=1;j<ls.size();j++){
                    sum += ls.get(j);
                }
                if(sum>max){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }
    }
}