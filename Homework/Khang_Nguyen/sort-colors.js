// /**
//  * @param {number[]} nums
//  * @return {void} Do not return anything, modify nums in-place instead.
//  */
//  var sortColors = function(nums) {
//     const len = nums.length
//     let i = 0
//     let leftMost1 = -1
//     let leftMost2 = -1
    
// // nums[i] === 2
// // no leftmost 2 => assign

// // nums[i] === 1 
// // - no leftmost 1 => assign then check if have leftmost 1 and 2 => if leftmost 1 > leftmost 2, -> swap leftmost 1 and 2 pos, assign leftmost 2 to leftmost 1, increase leftmost 2 by 1
// // - have leftmost 1 => have leftmost 2 => swap with leftmost 2, increase leftmost 2. 

// // nums[i] === 0
// // - have no leftmost => do nothing
// // - have only 1 leftmost => swap, incr leftmost index
// // - have both => swap i with leftmost 1, then swap i with leftmost 2, increase both leftmost by 1.        
//     while (i < len) {
//         switch (nums[i]) {
//         case 2:
//             if (leftMost2 === -1) {
//                 leftMost2 = i
//             }
//             break;
//         case 1:
//             if (leftMost1 === -1) {
//                 leftMost1 = i
//                 if (leftMost2 !== -1 && leftMost2 < leftMost1) {
//                     swap(i, leftMost2, nums)
//                     leftMost1 = leftMost2
//                     leftMost2++
//                 }
//             } else {
//                 if (leftMost2 !== -1) {
//                     swap(i, leftMost2, nums)
//                     leftMost2++
//                 }
//             }
//             break;
//         case 0:
//             if (leftMost1 !== -1 && leftMost2 !== -1) {
//                 swap(i, leftMost1, nums)
//                 swap(i, leftMost2, nums)
//                 leftMost1++
//                 leftMost2++
//             }
//             else if (leftMost1 !== -1) {
//                 swap(i, leftMost1, nums)
//                 leftMost1++
//             } else if (leftMost2 !== -1) {
//                 swap(i, leftMost2, nums)
//                 leftMost2++
//             }
//             break;
//         }
//         i++
//     }
// };
var sortColors = function(nums) {
    let index = -1
    let len = nums.length
    for (let i = 0; i < len; i++) {
        if (nums[i] === 0) {
            index++
            swap(i, index, nums)
        }
    }
    for (let i = index + 1; i < len; i++) {
        if (nums[i] === 1) {
            index++
            swap(i, index, nums)
        }
    }
};
function swap(a, b, arr) {
    const temp = arr[a]
    arr[a] = arr[b]
    arr[b] = temp
}