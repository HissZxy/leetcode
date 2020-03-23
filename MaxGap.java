import java.util.*;

public class MaxGap {
 public int findMaxGap(int[] A, int n) {
        //leftmax存放左边数组的最大值，rightmax存放右边数组的最大值
        //value存放差值，temp存放每次的最大值
        int leftmax = 0 , rightmax = 0 ,value = 0 , temp = 0;
        //以K为分界线，K每次不断移动指针
        for(int K = 0 ; K < n-1 ; K++){
            //做一个判断。如果是第一次从左到K找最大数
            //就进入for循环，如果不是第一次找最大数，
            //因为前面已经在K-1个数中找到了最大数，所以不用从新开始找
            //只需要和第K个数比较一下就可以了
            if (value != 0 && A[K] > leftmax) {
                leftmax = A[K];
            } else {
                leftmax = A[0];
                // i每次从0开始遍历到K的位置，并且返回最大值
                for (int i = 0; i <= K; i++) {
                    leftmax = A[i] > leftmax ? A[i] : leftmax;
                }
            }
            rightmax = A[K+1];
            //j从K+1处开始遍历，并且返回数组最大值
            for(int j = K+1 ;j<n ; j++){
                rightmax = A[j]>rightmax?A[j]:rightmax;
            }
            //记录差值
            value = leftmax - rightmax;
            //差值小于0，取绝对值
            value = value<0?-value:value;
            //如果当前差值比上次差值大，替换差值
            temp = value>temp?value:temp;
        }
        //返回差值
        return temp;
    }
}