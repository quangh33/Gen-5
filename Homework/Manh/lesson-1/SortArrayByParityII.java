class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int odd = 1;
        int even = 0;
        while(odd<nums.length && even<nums.length){
            if(nums[even] % 2 != 0){
                swap(odd, even, nums);
                odd = odd + 2;
            } else {
                even = even + 2;
            }
        }
        return nums;
    }
    
    private void swap(int x, int y, int[] nums) {
        if(x==y) return;
        nums[x] = nums[x] + nums[y];
        nums[y] = nums[x] - nums[y];
        nums[x] = nums[x] - nums[y];
    }
}