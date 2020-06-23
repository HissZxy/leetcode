import java.util.Scanner;
public class Main{
     
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int input = sc.nextInt();
            System.out.println(Main.getNumber(input));
                         
        }
    }
    //通过列举出每月的有生育能力兔子的数目，没有生能力的兔子的说目，
    //一月大的兔子的数目和二月大的兔子的数目可知
    public static int getNumber(int mounth){
        if(mounth == 1 || mounth == 2){
            return 1;
        }
        int tempold = 1;
        int tempyoung = 1;
        int mounth1 = 1;
        int mounth2 = 0;
        for(int j = 4; j <= mounth; j++){
            //第一步，第二个月的变成了有生育能力的兔子
            tempold += mounth2;
            //第二步，一个月大的兔子变成了两个月大的兔子
            mounth2 = mounth1;
            //第三步，有生育能力的兔子生出了一个月大的小兔子
            mounth1 = tempold;
            //当月小兔子的个数
            tempyoung = mounth1 + mounth2;         
        }
        return tempold + tempyoung;
    }
}