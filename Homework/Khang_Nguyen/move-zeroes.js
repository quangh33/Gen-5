
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
 const swap = (indexA, indexB, arr) => {
    const temp = arr[indexA]
    arr[indexA] = arr[indexB]
    arr[indexB] = temp
}
var moveZeroes = function(nums) {
  const len = nums.length
  let leftMostZeroIndex = -1;
  for (let i = 0; i < len; i++) {
      if (nums[i] === 0) {
          if (leftMostZeroIndex === -1) {
            leftMostZeroIndex = i            
          }
      } else if (leftMostZeroIndex !== -1) {
          swap(leftMostZeroIndex, i, nums)
          leftMostZeroIndex++
      }
  }
};