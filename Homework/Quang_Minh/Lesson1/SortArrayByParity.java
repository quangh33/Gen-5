class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int size = nums.length;
        int position = 0;
        for (int i = 0; i < size; i++) {
            if (nums[i] % 2 == 0) {
                swap(nums, position, i);
                position++;
            }
        }
        position = size - 1;
        for (int i = size - 1; i >= 0; i--) {
            if (nums[i] % 2 != 0) {
                swap(nums, position, i);
                position--;
            }
        }
        return nums;
    }

    private void swap(int[] input, int i, int j) {
        if (i != j) {
            input[i] = input[i] + input[j];
            input[j] = input[i] - input[j];
            input[i] = input[i] - input[j];
        }
    }
}