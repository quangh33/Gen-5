/**
 * @param {number[]} nums
 * @return {number[]}
 */
var frequencySort = function (nums) {
  // count frequency of each num
  const numToFreqMap = new Map();
  for (const num of nums) {
    numToFreqMap.set(num, (numToFreqMap.get(num) || 0) + 1);
  }

  // transform into map of frequency -> nums array sorted in decreasing order
  const freqToNumsMap = new Map();
  let maxFreq = 0;
  for (const num of numToFreqMap.keys()) {
    const freq = numToFreqMap.get(num);
    if (maxFreq < freq) {
      maxFreq = freq;
    }
    if (freqToNumsMap.has(freq)) {
      const nums = freqToNumsMap.get(freq);
      // find index for inserted num
      let i = 0;
      while (num < nums[i]) {
        i++;
      }
      // insert num to index i
      nums.splice(i, 0, num);
    } else {
      freqToNumsMap.set(freq, [num]);
    }
  }

  const result = [];
  // insert nums into result array
  for (let freq = 1; freq <= maxFreq; freq++) {
    if (freqToNumsMap.has(freq)) {
      const nums = freqToNumsMap.get(freq);
      for (const num of nums) {
        for (let i = 0; i < freq; i++) {
          result.push(num);
        }
      }
    }
  }
  return result;
};
