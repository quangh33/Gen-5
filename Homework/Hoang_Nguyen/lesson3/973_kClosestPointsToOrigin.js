function partition(nums, low, high) {
  console.log(low, high);
  const pivot = nums[high].value;
  let j = low - 1;
  for (let i = low; i < high; i++) {
    // sort by increasing order
    if (nums[i].value < pivot) {
      j++;
      // swap i & j
      [nums[i], nums[j]] = [nums[j], nums[i]];
    }
  }
  j++;
  // swap j & high
  [nums[high], nums[j]] = [nums[j], nums[high]];
  return j;
}

/**
 * @param {number[][]} points
 * @param {number} k
 * @return {number[][]}
 */
var kClosest = function (points, k) {
  const distances = [];
  for (let i = 0; i < points.length; i++) {
    const p = points[i];
    distances.push({
      index: i,
      value: p[0] ** 2 + p[1] ** 2,
    });
  }
  let low = 0;
  let high = distances.length - 1;
  while (low < high) {
    let p = partition(distances, low, high);
    if (p === k - 1) {
      break;
    } else if (p < k - 1) {
      low = p + 1;
    } else {
      high = p - 1;
    }
  }
  return distances.slice(0, k).map((d) => points[d.index]);
};
