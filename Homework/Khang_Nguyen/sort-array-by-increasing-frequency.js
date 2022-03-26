var frequencySort = function(nums) {
  const freq = nums.reduce((rs, num) => {
    if (rs[num]) {
      rs[num] += 1
    } else {
      rs[num] = 1
    }
    return rs
  }, {})
  const entries = Object.entries(freq).map(item => [parseInt(item[0]), item[1]])
  // sort lower freq first, if equal sort by value 
  const sorted = entries.sort((a, b) => freq[a[0]] - freq[b[0]] || b[0] - a[0]) 
  const result = []
  sorted.forEach((tuple) => {
    result.push(...Array(tuple[1]).fill(tuple[0]))
  })

  return result
};