
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
         * sum 总距离
         * repetition  三个节点 中被重复计算的总距离
         * select 优化距离最大的  三个节点两两相加的距离
         * add 三个结尾距离为max 中 头尾节点的距离
         * last最后三个节点中 尾距离没有被计算两次 需要加上
         * optimizeDistance 优化距离
         */
 
        int sum=0,repetition=0,select=0,add=0,
                last=0,optimizeDistance = 0;
        for(int i=0;i<=arrays.length-3;i++){
            int begin=arrays[i];
            int mid=arrays[i+1];
            int end=arrays[i+2];
            //三个点之间的距离
            int threePointDistance=Math.abs(mid-begin)
                    +Math.abs(end-mid);
            //两个点之间的距离  即被多次计算待会需要减掉的距离
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