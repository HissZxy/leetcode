public class Solution {
     
    public int calculateMax(int[] prices) {
        if(prices==null || prices.length<2)return 0;
        int sum=0;
        for(int i=1;i<prices.length;i++){
            int temp=getMax(prices,0,i)+getMax(prices,i+1,prices.length-1);
            if(temp>sum)sum=temp;
        }
        return sum;
    }
    public static int getMax(int[] prices,int left,int right){
        if(left>=prices.length)return 0;
        int Min=prices[left];
        int ret=0;
        for(int i=left+1;i<=right;i++){
            Min=Math.min(prices[i],Min);
            ret=Math.max(ret,prices[i]-Min);
        }
        return ret;
    }
}