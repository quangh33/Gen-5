/**
 * @param {number[][]} points
 * @param {number} k
 * @return {number[][]}
 */
var kClosest = function(points, K) {
  const swap = (i1, i2) => {
    [points[i1], points[i2]] = [points[i2], points[i1]];
  };
  const distance = point => point[0] ** 2 + point[1] ** 2;

  const partition = (lo, hi) => {
    // pick last one as pivot
    const pivotDist = distance(points[hi]);
    let targetPivotIdx = lo,
      searchIdx = lo;
    // compare from lo to hi
    while (searchIdx < hi) {
      const dist = distance(points[searchIdx]);
      if (dist <= pivotDist) {
        swap(searchIdx, targetPivotIdx);
        targetPivotIdx += 1;
      }
      searchIdx += 1;
    }
	// hi goes to target pivot
    swap(hi, targetPivotIdx);
    return targetPivotIdx;
  };

  const quickSelect = (lo, hi, target) => {
    const pivot = partition(lo, hi);
    if (pivot === target - 1) return;
    if (pivot < target - 1) {
      quickSelect(pivot + 1, hi, target);
    } else {
      quickSelect(lo, pivot - 1, target);
    }
  };

  quickSelect(0, points.length - 1, K);
  return points.slice(0, K);
};