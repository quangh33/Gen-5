/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    let res = [[]];
    for(let i=0;i<nums.length;i++) {
        let size = res.length;
        for(let j=0;j<size;j++) {
            let curr = res[j];
            res.push([...curr, nums[i]]);
        }
    }
    return res;
};