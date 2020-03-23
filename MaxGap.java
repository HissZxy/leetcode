import java.util.*;

public class MaxGap {
 public int findMaxGap(int[] A, int n) {
        //leftmax��������������ֵ��rightmax����ұ���������ֵ
        //value��Ų�ֵ��temp���ÿ�ε����ֵ
        int leftmax = 0 , rightmax = 0 ,value = 0 , temp = 0;
        //��KΪ�ֽ��ߣ�Kÿ�β����ƶ�ָ��
        for(int K = 0 ; K < n-1 ; K++){
            //��һ���жϡ�����ǵ�һ�δ���K�������
            //�ͽ���forѭ����������ǵ�һ�����������
            //��Ϊǰ���Ѿ���K-1�������ҵ�������������Բ��ô��¿�ʼ��
            //ֻ��Ҫ�͵�K�����Ƚ�һ�¾Ϳ�����
            if (value != 0 && A[K] > leftmax) {
                leftmax = A[K];
            } else {
                leftmax = A[0];
                // iÿ�δ�0��ʼ������K��λ�ã����ҷ������ֵ
                for (int i = 0; i <= K; i++) {
                    leftmax = A[i] > leftmax ? A[i] : leftmax;
                }
            }
            rightmax = A[K+1];
            //j��K+1����ʼ���������ҷ����������ֵ
            for(int j = K+1 ;j<n ; j++){
                rightmax = A[j]>rightmax?A[j]:rightmax;
            }
            //��¼��ֵ
            value = leftmax - rightmax;
            //��ֵС��0��ȡ����ֵ
            value = value<0?-value:value;
            //�����ǰ��ֵ���ϴβ�ֵ���滻��ֵ
            temp = value>temp?value:temp;
        }
        //���ز�ֵ
        return temp;
    }
}