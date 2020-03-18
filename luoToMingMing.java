import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String str=scanner.nextLine();
            String[] words=str.split("_");
            String result=words[0];
            for(int i=1;i<words.length;i++){
                result+=(char)(words[i].charAt(0)-'a'+'A');
                for(int j=1;j<words[i].length();j++){
                    result+=words[i].charAt(j);
                }
            }
            System.out.println(result);
        }
    }
}