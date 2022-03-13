/**
 * @param {number[]} nums
 * @return {number[][]}
 */
 function getBit(num, pos) {
    return (num >> pos) & 1
}
var subsets = function(nums) {
    const len = nums.length
    const numberOfSubset = 2**len
    const end = numberOfSubset - 1
    const result = []
    for (let i=0; i<= end; i++) {
        const subset = []
        for (let pos = 0; pos < len; pos++) {
          if (getBit(i, pos) === 1) {
              subset.push(nums[pos])
          }
        }
        result.push(subset)
    }
    return result
};