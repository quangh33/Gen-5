    public void sortColors(int[] nums) {
        int size = nums.length;
        int position = 0;
        // move all 0, 1 to the left
        for (int i = 0; i < size; i++) {
            if (nums[i] == 0) {
                if (position != i) {
                    nums[i] = nums[position] + nums[i];
                    nums[position] = nums[i] - nums[position];
                    nums[i] = nums[i] - nums[position];
                }
                position++;
            }
        }
        // move all 1, 2 tho the right
        position = size - 1;
        for (int i = size - 1; i >=0 ; i--){
            if (nums[i] == 2) {
                if (position != i) {
                    nums[i] = nums[position] + nums[i];
                    nums[position] = nums[i] - nums[position];
                    nums[i] = nums[i] - nums[position];
                }
                position--;
            }
        }
    }