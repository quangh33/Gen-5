/**
 * @param {number[]} nums
 * @return {number[]}
 */
 function swap(start, end, arr){
    const temp = arr[start]
    arr[start] = arr[end]
    arr[end] = temp
}

var sortArrayByParity = function(nums) {
    const len = nums.length
    let leftMostOdd = -1
    for (let i = 0; i < len; i++) {
        if (nums[i] % 2 !== 0) {
            if (leftMostOdd === -1) {
                leftMostOdd = i
            }
        } else {
            if (leftMostOdd !== -1) {
                swap(leftMostOdd, i, nums)
                leftMostOdd++                
            }
        }
    }
    return nums
};

// Time: O(n)
// Space: O(1)