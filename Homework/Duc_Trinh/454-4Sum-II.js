/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @param {number[]} nums3
 * @param {number[]} nums4
 * @return {number}
 */

var fourSumCount = function(nums1, nums2, nums3, nums4) {
    const len = nums1.length
    let count = 0
    const precomputedSumsForNums1AndNums2 = new Map()
    const precomputedSumsForNums3AndNums4 = new Map()

    for (let i = 0; i < len; i++) {
        for (let j = 0; j < len; j++) {
            const sum = nums1[i] + nums2[j]
            if (precomputedSumsForNums1AndNums2.has(sum)) {
                precomputedSumsForNums1AndNums2.set(sum, precomputedSumsForNums1AndNums2.get(sum) + 1)
            } else {
                precomputedSumsForNums1AndNums2.set(sum, 1)
            }
        }
    }
    for (let i = 0; i < len; i++) {
        for (let j = 0; j < len; j++) {
            const sum = nums3[i] + nums4[j]
            if (precomputedSumsForNums3AndNums4.get(sum)) {
                precomputedSumsForNums3AndNums4.set(sum, precomputedSumsForNums3AndNums4.get(sum)+ 1)
            } else {
                precomputedSumsForNums3AndNums4.set(sum, 1)
            }
        }
    }

    const sums12 = Array.from(precomputedSumsForNums1AndNums2.keys())
    const sums34 = Array.from(precomputedSumsForNums3AndNums4.keys())
    for (let i = 0; i < sums12.length; i++) {
        for (let j = 0; j < sums34.length; j++) {        
            const sum12 = sums12[i]
            const sum34 = sums34[j]
            if (parseInt(sum12) + parseInt(sum34) === 0) {
                count = count + precomputedSumsForNums1AndNums2.get(sum12) * precomputedSumsForNums3AndNums4.get(sum34)
            }
        }
    }
    return count
};

