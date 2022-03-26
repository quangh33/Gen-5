var maxSlidingWindow = function(nums, k) {
    const result = []
    const len = nums.length
    if (len <= k) return [Math.max(...nums)]
    
    let sliding = [] 
    let max = nums[0]
    
    for (let i = 0; i < len ; i++) {
      
      if (nums[i] > max) {
        sliding = [i] 
      } else {
        while (sliding.length > 0 && nums[right(sliding)] < nums[i]) {
          sliding.pop()
        }
        sliding.push(i)
      }

      if (sliding[0] < i - k + 1) {
        sliding.splice(0, 1)
      }
      max = nums[sliding[0]]
      
      if (i >= k - 1) {
        result.push(max)
      }
    }
    return result 
};

function right(arr) { return arr[arr.length - 1]}