/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortArrayByParityII = function(nums) {
    let evenArr = []; let oddArr = []; let res = [];
    for(let i=0;i<nums.length;i++) {
        if(nums[i]%2 == 0)
            evenArr.push(nums[i])
        else
            oddArr.push(nums[i])
    }
    
    for(let i=0;i<nums.length/2;i++) {
        res.push(evenArr[i]);
        res.push(oddArr[i]);
    }
    
    return res;
};