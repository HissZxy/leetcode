public class Solution {


public int calculateMax(int[] prices) {
       int firstBuy = Integer.MAX_VALUE;//第一次买入的价格
       // 接下来都是买入卖出之后的收益
       int afterFirstSell = 0;
       int afterSecondBuy = Integer.MIN_VALUE;
       int afterSecondSell = 0;
        
       for (int curPrice: prices){
           //第一次买入的价格应该是越小越好，最好是负数，倒贴钱
           firstBuy = Math.min(firstBuy, curPrice);
           //第一次卖出后的收益，等于当前价格减去第一次买入价格，越高越好
           afterFirstSell = Math.max(afterFirstSell, curPrice - firstBuy);
           //第二次买入后的收益，等于第一次卖出后的收益减去当前价格，越高越好
           afterSecondBuy = Math.max(afterSecondBuy, afterFirstSell - curPrice);
           //第二次卖出后的收益，等于第二次买入后的收益加上当前价格，越高越好
           afterSecondSell = Math.max(afterSecondSell, afterSecondBuy + curPrice);
       }
       return afterSecondSell;
   }