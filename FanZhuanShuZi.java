class Solution {
    public int reverse(int x) {
String xString = Integer.toString(x);
        String string = xString;
        int flag = 1;
        if (x < 0) {
            flag = -1;
            string = xString.substring(1);
        }
        try {
            return Integer.valueOf((new StringBuilder(string)).reverse().toString()) * flag;
        }catch (Exception e){
            return 0;
        }
    }