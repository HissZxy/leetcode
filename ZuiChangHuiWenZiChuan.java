class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for(int i =0;i<s.length();i++){
            i = findLongest(str , i ,range);
        }
        return s.substring(range[0],range[1]+1);
    }
    public static int findLongest(char[] str , int low, int[] range){
        int high = low;
         while (high < str.length - 1 && str[high + 1] == str[low]) {
        high++;
        }
//         定位中间部分的最后一个字符
        int ans = high;
//         从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
//         记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }
}