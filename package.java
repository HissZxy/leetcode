

import java.util.Scanner;
 
public class Main {
    static int count=0;//��ʾ�ж�����
    static int[] arr; //��ʾ�ڴ�
    static int n;//��ʾ��Ʒ������
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            n=input.nextInt();
            arr=new int[n+1];
            /*����Ĵ�С�������õı���Ʒ������Ҫ��1����Ϊ���±߽��еݹ��ʱ��
            �����СΪn,��Ϊ�ڷŵ�һ����ʱ��Ҫ���ǵ�һ����ǰһ�������ŷŵģ�������ŷŷ���һ�㣩��
            �����СΪn�Ļ�������������
             */
            for(int i=1;i<=n;i++){
                arr[i]=input.nextInt();
            }
        }
        count(40,n);
        System.out.println(count);
    }
    public static void count(int s,int n){
        /**
         * s��ʾ����ʣ�µ�������С
         * n��ʾʣ�µĶ�������
         */
        //������������պõ����㣬˵���պ�װ��
        if(s==0){
            count++;
        }
        //��������С����������������㵫�Ƕ�������С���㣬���ܸպ�װ����Ҳ����Ҫôװ������Ҫô����װ�ˣ�
        if(s<=0||(s>0&&n<0)){
            return ;
        }
        //�����һ����ʼװ
        count(s-arr[n],n-1);
        //������һ���������Ƕ�ֵ���ˣ��ӵ����ڶ�����ʼ
        count(s,n-1);
    }
}