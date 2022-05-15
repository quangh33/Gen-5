/**
 * @param {number[]} arr
 * @return {number}
 */
var longestMountain = function (arr) {
  const n = arr.length;
  let res = 0;
  let i = 0;
  while (i < n) {
    let top = i;
    while (top + 1 < n && arr[top + 1] > arr[top]) {
      top++;
    }
    let bottom = top;
    while (bottom + 1 < n && arr[bottom + 1] < arr[bottom]) {
      bottom++;
    }
    if (i < top && top < bottom) {
      res = Math.max(res, bottom - i + 1);
    }

    if (i < bottom) {
      i = bottom;
    } else {
      i++;
    }
  }
  return res;
};
