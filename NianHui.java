import java.util.Scanner;
public class Main{
    //这道题着实让我折腾了好半天，首先要明白这是一个排列组合问题，
    //我们拿5来说事，首先5个人来进行抽奖，有多少种抽法？
    //因为是不放回抽，所以第一个人有5种抽法，
    //第二个人有4种抽法，依次类推
    //总共就是5！ 对有5的阶乘种抽法。这是分母
    //那可想而知分子就是存在多少种情况每个人拿不到自己的名字。
    //这里要应用错排算法。
    //简单的做个介绍
    //当n个编号元素放在n个编号位置，元素编号与位置编号各不对应的方法数用D(n)表示，
    //那么D(n-1)就表示n-1个编号元素放在n-1个编号位置，各不对应的方法数，其它类推.
    //第一步，把第n个元素放在一个位置，比如位置k，一共有n-1种方法；
    //第二步，放编号为k的元素，这时有两种情况：把它放到位置n，那么，对于剩下的n-1个元素，
    //由于第k个元素放到了位置n，剩下n-2个元素就有D(n-2)种方法；
    //第k个元素不把它放到位置n，这时，对于这n-1个元素，有D(n-1)种方法；
    //综上得到递推公式，可以发现可以用递归来做；
    //D(n) = (n-1) [D(n-2) + D(n-1)]
    //特殊地，D(1) = 0, D(2) = 1.
    //那么D(5)=4*[D(3)+D(4)]；依次求得D(3)、D(4),最后D(5)=44
    //所以5个人拿不到奖的概率就是44/120=36.67%
    //这里只是简单介绍，具体想弄明白还是去百度错排算法吧
    //下面看代码
    public static float count(int n) {
        //这个函数用来得到有多少种可能，每个人拿不到自己的名字，
        //也就是得到分子
        if(n==1){
            //n=1的时候返回0
            return 0;
        }
        if(n==2){
            //n=2的时候返回1
            return 1;
        }else{
            //否则就递归。
            return (n-1)*(count(n-1)+count(n-2));
        }
    }
    //下面的函数用来求阶乘，也是递归，最后得到分母
    public static float probability(int n){
       if(n==0){
           //0的阶乘等于1，不用多说吧
           return 1;
       }else{
           //阶乘表示，进行递归
           return n*probability(n-1);
       }
    }
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            int n = sc.nextInt();
            //将得到的分子分母进行相除，就可以得到概率了。
            float result = (count(n)/probability(n))*100;
            System.out.println(String.format("%.2f", result) + "%");
        } while (sc.hasNext());
    }
}