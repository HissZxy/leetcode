
import java.util.Scanner;
 public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int length=scanner.nextInt();
        int[]arrays=new int[length];
        for(int i=0;i<length;i++){
            arrays[i]=scanner.nextInt();
        }
        /**
         * sum �ܾ���
         * repetition  �����ڵ� �б��ظ�������ܾ���
         * select �Ż���������  �����ڵ�������ӵľ���
         * add ������β����Ϊmax �� ͷβ�ڵ�ľ���
         * last��������ڵ��� β����û�б��������� ��Ҫ����
         * optimizeDistance �Ż�����
         */
 
        int sum=0,repetition=0,select=0,add=0,
                last=0,optimizeDistance = 0;
        for(int i=0;i<=arrays.length-3;i++){
            int begin=arrays[i];
            int mid=arrays[i+1];
            int end=arrays[i+2];
            //������֮��ľ���
            int threePointDistance=Math.abs(mid-begin)
                    +Math.abs(end-mid);
            //������֮��ľ���  ������μ��������Ҫ�����ľ���
            int twoPointDistance=Math.abs(end-mid);
            int contrast=threePointDistance - Math.abs(begin-end);
 
            repetition+=twoPointDistance;
            sum+=threePointDistance;
            last=twoPointDistance;
 
            if(contrast>optimizeDistance){
                optimizeDistance = contrast;
                select=threePointDistance;
                add=Math.abs(end-begin);
            }
 
        }
        System.out.println(sum-select+last-repetition+add);
 
    }
 
}