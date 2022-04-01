var productExceptSelf = function(nums) {
  let product = 1
  const len = nums.length
  const output = []

  for (let i = 0; i < len; i++) {
    product *= nums[i]
    output[i] = product
  }
  
  product = 1
  output.unshift(1)
  for (let i = len; i > 0; i--) {
    output[i] = output[i - 1] * product
    product = product * nums[i - 1]
  }
  
  return output.slice(1)
};