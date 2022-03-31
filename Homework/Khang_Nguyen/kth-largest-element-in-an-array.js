var findKthLargest = function(nums, k) {
  const len = nums.length
  if (nums.length === 1) return nums[0]
  const mid = Math.floor(len/2) - 1
  const midValue = nums[mid]

  const midPosAfterSort = sortByMidValue(nums, mid)
  // mid index will show mid is the mid + 1 largest number
  if (k === midPosAfterSort + 1) {
    return midValue 
  }
  if (k > midPosAfterSort + 1) {
    return findKthLargest(nums.slice(midPosAfterSort + 1), k - midPosAfterSort - 1)
  }
  
  return findKthLargest(nums.slice(0, midPosAfterSort), k)
};

function sortByMidValue(arr, index){
  const len = arr.length
  const flagValue = arr[index]

  let swapIndex = -1
  
  for (let i=0;i < len;i++) {
    if (arr[i] > flagValue) {
      swapIndex++
      swap(swapIndex, i, arr)
    }
  }
  for (let i=swapIndex + 1;i < len;i++) {
    if (arr[i] === flagValue) {
      swapIndex++
      swap(swapIndex, i, arr)
    }
  }
  return swapIndex
}
function swap(i, j, arr) {
  const temp = arr[i]
  arr[i] = arr[j]
  arr[j] = temp
}