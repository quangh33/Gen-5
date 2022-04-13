/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */

var maxSlidingWindow = function(nums, k) {
    // use this example if needed...
    // 6 2 6 6 7 1 2 3 4 5  nums
    // k = 5
    // 7 7 7 7 7 5 result

    let maxHeap = new MaxHeap();
    let result = [];

    for (let i = 0; i < nums.length; i++) {
        maxHeap.insert(i, nums[i]);

        if (i+1 >= k) { // when the window reach size k; from there after...
            let top = maxHeap.peek();
            // if top is within the window, loop will be skipped and top will be pushed to result
            // else the loop will find the next top that is within the window and push that instead
            while (top.index <= i-k) { // index i-k is not in the window
                maxHeap.remove();
                top = maxHeap.peek();
            }
            result.push(top.value);
        }
    }
    return result;
};
// ********
// MaxHeap
// ********
class MaxHeap {
    constructor() {
        this.list = [];
    }

    insert(index, value) {
        this.list.push({index, value});
        this.percolateUp(this.list.length-1);
    }

    percolateUp(heapIndex) {
        // parent = (child-1) / 2
        let tmp = this.list[heapIndex];
        while (Math.floor((heapIndex-1)/2) >= 0) {
            let parentIndex = Math.floor((heapIndex-1)/2);
            if (this.list[parentIndex].value < tmp.value) {
                this.list[heapIndex] = this.list[parentIndex];
                heapIndex = parentIndex;
            } else {
                break;
            }
        }
        this.list[heapIndex] = tmp;
    }

    peek() {
        return this.list[0];
    }

    remove() {
        let removed = this.list[0];
        let popped = this.list.pop();
        if (this.list.length > 0) {
            this.list[0] = popped;
            this.percolateDown(0);
        }
        return removed;
    }

    percolateDown(heapIndex) {
        // child index = 2p+1 / 2p+2
        let tmp = this.list[heapIndex];
        while (heapIndex*2+1 < this.list.length) {
            // find the large child
            let child = heapIndex*2+1;

            // if child larger than temp => swap
            if (this.list[child+1] &&
                this.list[child+1].value > this.list[child].value) {
                child = child + 1;
            }

            if (this.list[child].value > tmp.value) {
                this.list[heapIndex] = this.list[child]
                heapIndex = child;
            } else {
                break
            }
        }
        this.list[heapIndex] = tmp;
    }

}