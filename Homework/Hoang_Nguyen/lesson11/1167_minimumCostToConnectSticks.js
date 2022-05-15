/**
 * @param {number[]} sticks
 * @return {number}
 */
var connectSticks = function (sticks) {
  const minPQ = new MinPriorityQueue();
  sticks.forEach((stick) => minPQ.enqueue(stick));
  let res = 0;
  while (minPQ.size() > 1) {
    const num1 = minPQ.dequeue().element;
    const num2 = minPQ.dequeue().element;
    const sum = num1 + num2;
    res += sum;
    minPQ.enqueue(sum);
  }
  return res;
};
