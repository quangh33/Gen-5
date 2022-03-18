/**
 * @param {number[]} nums
 * @return {number[]}
 */
function swap(start, end, arr) {
    const temp = arr[start]
    arr[start] = arr[end]
    arr[end] = temp
}
var sortArrayByParityII = function(nums) {
  const len = nums.length
  let nextOddIndex = 1
  let nextEvenIndex = 0
  
  while (nextEvenIndex < len || nextOddIndex < len - 1) {
      const isEvenPass = nums[nextEvenIndex] % 2 === 0
      const isOddPass = nums[nextOddIndex] % 2 === 1

      if (isEvenPass) {
          nextEvenIndex += 2
      } else if (isOddPass) {
          nextOddIndex += 2
      } else if (!isEvenPass && !isOddPass) {
          swap(nextEvenIndex, nextOddIndex, nums)
          nextEvenIndex += 2
          nextOddIndex += 2
      }
  }
  return nums
};