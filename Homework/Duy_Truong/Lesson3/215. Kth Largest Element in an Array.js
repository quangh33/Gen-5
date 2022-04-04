/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function(nums, k) {
    const swap = (i, j) => {
        const temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    };
    
    const partition = (low, high) => {
      let i = low - 1;
        for(let j = low; j < high; j++) {
            if(nums[j] <= nums [high]) {
                i++;
                swap(j, i);
            }
        }
        swap(i+1, high);
        return i + 1;
    };
    
    const sort = (low, high) => {
        const k_smallest = nums.length - k;
        while(low <= high) {
            const pivot = partition(low, high);
            if(pivot === k_smallest) {
                return nums[k_smallest];
            } 
            if(pivot < k_smallest) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
    };
    return sort(0, nums.length - 1);
};