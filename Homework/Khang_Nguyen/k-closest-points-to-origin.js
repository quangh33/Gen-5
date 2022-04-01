/**
 * @param {number[][]} points
 * @param {number} k
 * @return {number[][]}
 */
var kClosest = function (points, k) {
  const pointsWithDistance = points.map((point) => [
    ...point,
    Math.sqrt(point[0] * point[0] + point[1] * point[1]),
  ])
  const result = [] 
  recursion(pointsWithDistance, k, result) 
  return result.map(point => [point[0], point[1]])
}

function recursion(arr, k, result) {
  if (arr.length === 1) {
      result.push(arr[0])
      return;
  }

  const midPosAfterSort = sortByLastValue(arr)

  if (k === midPosAfterSort + 1) {
    arr.slice(0, midPosAfterSort + 1).forEach((point) => result.push(point))
    return;
  }
  if (k < midPosAfterSort + 1) {
    recursion(arr.slice(0, midPosAfterSort), k, result) 
    return;
  } else {
    arr.slice(0, midPosAfterSort + 1).forEach((point) => result.push(point))
    recursion(arr.slice(midPosAfterSort + 1), k - midPosAfterSort - 1, result) 
    return;
  }
}

function sortByLastValue(arr) {
  const len = arr.length
  const mid = Math.floor(len/2) - 1
  const flagValue = arr[mid][2]

  let swapIndex = -1

  for (let i = 0; i < len; i++) {
    if (arr[i][2] < flagValue) {
      swapIndex++
      swap(swapIndex, i, arr)
    }
  }
  for (let i = swapIndex + 1; i < len; i++) {
    if (arr[i][2] === flagValue) {
      swapIndex++
      swap(swapIndex, i, arr)
    }
  }
  return swapIndex
}

function swap(i, j, arr) {
  const temp = arr[i]
  arr[i] = arr[j]
  arr[j] = temp
}
