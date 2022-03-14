class Solution {
    public void moveZeroes(int[] nums) {
        int num = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]!=0) {
                swap(i, num, nums);
                num++;
            }
        }
    }
    
    private void swap(int x, int y, int[] nums){
        if(x==y) return;
        nums[x] = nums[x] + nums[y];
        nums[y] = nums[x] - nums[y];
        nums[x] = nums[x] - nums[y];
    }
}