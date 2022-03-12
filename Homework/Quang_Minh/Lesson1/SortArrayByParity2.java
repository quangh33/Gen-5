class SortArrayByParity2 {
    public int[] sortArrayByParityII(int[] nums) {
        int indexEvenElement = 0;
        int indexOddElement = 1;
        int size = nums.length;
        while (true) {
            if (indexEvenElement >= size || indexOddElement >= size) break;
            while (indexEvenElement < size && nums[indexEvenElement] % 2 == 0) {
                indexEvenElement += 2;
            }
            while (indexOddElement < size && nums[indexOddElement] % 2 == 1) {
                indexOddElement += 2;
            }
            while (indexEvenElement < size && indexOddElement < size 
                   && nums[indexEvenElement] % 2 == 1 && nums[indexOddElement] % 2 == 0) {
                nums[indexEvenElement] = nums[indexEvenElement] + nums[indexOddElement];
                nums[indexOddElement] = nums[indexEvenElement] - nums[indexOddElement];
                nums[indexEvenElement] = nums[indexEvenElement] - nums[indexOddElement];
                indexOddElement += 2;
                indexEvenElement += 2;
            }
        }
        return nums;
    }
}