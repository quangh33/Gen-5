class RangeSumQuery {

    int[] prefixSumArray;
    public NumArray(int[] nums) {
        prefixSumArray = new int[nums.length];
        prefixSumArray[0] = nums[0];
        for (int i = 1 ; i < nums.length ; i++){
            prefixSumArray[i] = prefixSumArray[i-1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return left == 0 ? prefixSumArray[right] : prefixSumArray[right] - prefixSumArray[left - 1];
    }
}
