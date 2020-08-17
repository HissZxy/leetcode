class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
List<List<Integer>> res = new ArrayList<>();
        if (nums==null||nums.length<4){
            return res;
        }

        Arrays.sort(nums);
        int length = nums.length;
        for (int x=0;x<length-3;x++){
            //转换成三数之和
            if(x>0&&nums[x]==nums[x-1]){
                continue;
            }

            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min1=nums[x]+nums[x+1]+nums[x+2]+nums[x+3];
            if(min1>target){
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1=nums[x]+nums[length-1]+nums[length-2]+nums[length-3];
            if(max1<target){
                continue;
            }

            for (int i = x+1;i<length-2;i++){
                if(i>x+1&&nums[i]==nums[i-1]){
                    continue;
                }
                int head = i+1;
                int rear = length-1;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略*/
                int min=nums[x]+nums[i]+nums[head]+nums[head+1];
                if(min>target){
                    continue;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max=nums[x]+nums[i]+nums[rear]+nums[rear-1];
                if(max<target){
                    continue;
                }
                while (head<rear){
                    //这里不能用target去减掉他们的和，然后判断和0的关系，不知为啥，这样做是出不了答案的
                    int check = nums[x]+nums[i]+nums[head]+nums[rear];
                    if (check==target){
                        List<Integer> re = new ArrayList<>();
                        re.add(nums[i]);
                        re.add(nums[head]);
                        re.add(nums[rear]);
                        re.add(nums[x]);
                        res.add(re);
                        head++;
                        rear--;

                        while (head<rear&&nums[head]==nums[head-1]){
                            head++;
                        }
                        while (head<rear&&nums[rear]==nums[rear+1]){
                            rear--;
                        }
                    }else if (check<target){
                        head++;
                    }else {
                        rear--;
                    }
                }
            }
        }
        return res;
    }
}