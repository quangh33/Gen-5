class MoveZeros {
    public void moveZeroes(int[] nums) {
        int size = nums.length;
        int position = 0;
        for (int i = 0; i < size; i++) {
            if (nums[i] != 0) {
                if (position != i) {
                    nums[i] = nums[position] + nums[i];
                    nums[position] = nums[i] - nums[position];
                    nums[i] = nums[i] - nums[position];
                }
                position++;
            }
        }
        //for (int i : nums) System.out.print(i + " ");
    }
}