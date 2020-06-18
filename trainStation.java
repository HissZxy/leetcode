import java.util.*;
public class Main {
    static ArrayList<String> l=new ArrayList<String>();    //������
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
            while(in.hasNext()) {
                l.clear();    //��̬������ÿ�������
                int nums=in.nextInt();
                int[] id=new int[nums];
                Stack<Integer> stack=new Stack<Integer>();
                for(int i=0;i<nums;i++) {
                    id[i]=in.nextInt();
                }
                trainOut(id,0,stack,"",0);
                Collections.sort(l);    //�Խ��������
                for(String str:l) {
                    System.out.println(str);
                }
            }
            in.close();
    }
        //iΪ��ջ������nΪ��ջ������str�洢һ�˽��
    public static void trainOut(int[] id,int i,Stack<Integer> s,String str,int n) {
        if(n==id.length) {
            l.add(str);    //������л𳵾���ջ�򽫵�ǰ�������
        }
        if(!s.empty()) {       //ջ�ǿ�ʱ��ջ
            int temp=s.pop();
            trainOut(id,i,s,str+temp+" ",n+1);
            s.push(temp);    //�ָ��ֳ�
        }
        if(i<id.length) {    //�����л�û�ж���ջ����ջ
            s.push(id[i]);   
            trainOut(id,i+1,s,str,n);
            s.pop();        //�ָ��ֳ�
        }          
    }
}