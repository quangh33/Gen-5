/**
 * @param {number[]} nums
 * @return {number[]}
 */
   
var frequencySort = function(nums) {
    const hashMap = {}
    for (let i = 0; i < nums.length; i++) {
        if (!hashMap[nums[i]]) {
            hashMap[nums[i]] = 1
        } else {
            hashMap[nums[i]] = hashMap[nums[i]] + 1
        }
    }
    const correctOrder = Object.keys(hashMap).sort((a,b) => {
        // return -1 (a first) or 1 (b first)
        if (hashMap[a] < hashMap[b]) return -1
        if (hashMap[a] > hashMap[b]) return 1
        if (hashMap[a] === hashMap[b]) {
            if (parseInt(a) > parseInt(b)) {
                return -1
            } else {
                return 1
            }
        }
    })
    
    let res = []
    for (let i = 0; i < correctOrder.length; i++) {
        for (let j = 0; j < hashMap[correctOrder[i]]; j++) {
            res.push(correctOrder[i])
        }
    }
    return res
};