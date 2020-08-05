class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int m = nums[0];
        for(int i = 1; i < nums.length;i++){
            if(m == nums[i]){
                count ++;
            }else{
                count --;
                if(count == 0){
                    m = nums[i + 1];
                }
            }
        }
        return m;
    }
}