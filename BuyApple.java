
import java.util.*;
public class Main{
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            System.out.println(count(n));
        }
    }
    public static int count(int n){
        if(n%2!=0||n==10||n<6) return -1;//һ����ż����6��8���ǣ�,��С��6��10����ż�������ԣ�
        if(n%8==0) return n/8;//����ð˸��������
        return 1+n/8;//����10���ϵ�ż����ֻҪ��8ȡ������Ϊ0����Ҫ��ǰ���1����2��8���ó�2������������Ϊ6��������������6���Ͳ����ã�������+1��
    }
}