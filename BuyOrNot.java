import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.next();
            String str2 = sc.next();
            LinkedList<Character> list = new LinkedList<Character>();
            for(int i = 0; i < str1.length(); i++){
                char ch = str1.charAt(i);
                list.add(ch);
            }
            int count = 0;
            for(int i = 0; i < str2.length(); i++){
                char  ch = str2.charAt(i);
                for(int j = 0; j < list.size(); j++){
                    if(ch == list.get(j)){
                        list.remove(j);
                        count++;
                        break;
                    }
                }
            }
            if(count == str2.length())
                System.out.println("Yes "+ (str1.length()-count));
            else
                System.out.println("No "+ (str2.length()-count));
        }
        sc.close();
    }   
}