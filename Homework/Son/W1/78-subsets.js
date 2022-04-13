/**
 * @param {number[]} nums
 * @return {number[][]}
 */
 var subsets = function(nums) {
    const result = [];
  result.push([]);   
  
  let size = nums.length
  
  for(let i = 1; i < (1<<size) ; i++){  
    let subset = [];
    let bitmask=0
      while(bitmask<size){
          if(i & (1 << bitmask)){
              subset.push( nums[bitmask] );
              console.log(subset)
          }
          bitmask++   
      }
      result.push(subset)
  }
  return result
};

// https://leetcode.com/problems/subsets/