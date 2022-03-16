class NumArray {

    int[] sums;
    
    public NumArray(int[] nums) {
        this.sums = new int[nums.length];
        sums[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sums[i] = nums[i] + sums[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return sums[right] - (left == 0 ? 0 : sums[left-1]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */