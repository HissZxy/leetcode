class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for(int i = 0; i<nums.length;i++){
            int num = nums[i];
            int count = 0;
            for(int j = 0;j<nums.length;j++){
                if(nums[j]<nums[i]){
                    count++;
                    res[i] = count;
                }
            }
        }
        return res;
    }
}