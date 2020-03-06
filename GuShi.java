public class Solution {


public int calculateMax(int[] prices) {
       int firstBuy = Integer.MAX_VALUE;//��һ������ļ۸�
       // ������������������֮�������
       int afterFirstSell = 0;
       int afterSecondBuy = Integer.MIN_VALUE;
       int afterSecondSell = 0;
        
       for (int curPrice: prices){
           //��һ������ļ۸�Ӧ����ԽСԽ�ã�����Ǹ���������Ǯ
           firstBuy = Math.min(firstBuy, curPrice);
           //��һ������������棬���ڵ�ǰ�۸��ȥ��һ������۸�Խ��Խ��
           afterFirstSell = Math.max(afterFirstSell, curPrice - firstBuy);
           //�ڶ������������棬���ڵ�һ��������������ȥ��ǰ�۸�Խ��Խ��
           afterSecondBuy = Math.max(afterSecondBuy, afterFirstSell - curPrice);
           //�ڶ�������������棬���ڵڶ���������������ϵ�ǰ�۸�Խ��Խ��
           afterSecondSell = Math.max(afterSecondSell, afterSecondBuy + curPrice);
       }
       return afterSecondSell;
   }