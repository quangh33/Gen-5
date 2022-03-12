class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int size = nums.length;
        int position = 0;
        for (int i = 0; i < size; i++) {
            if (nums[i] %2 == 0) {
                if (position != i) {
                    nums[i] = nums[position] + nums[i];
                    nums[position] = nums[i] - nums[position];
                    nums[i] = nums[i] - nums[position];
                }
                position++;
            }
        }
        position = size - 1;
        for (int i = size - 1; i >=0 ; i--){
            if (nums[i] %2 != 0) {
                if (position != i) {
                    nums[i] = nums[position] + nums[i];
                    nums[position] = nums[i] - nums[position];
                    nums[i] = nums[i] - nums[position];
                }
                position--;
            }
        }
        return nums;
    }
}