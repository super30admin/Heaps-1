// Time Complexity : O(NlogK)
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes.  I needed to find someone's implementation of a Heap in JS that was suitable for
// this problem.  Writing this in JS is really hard.

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */

class MinHeap {
    constructor(comparator) {
        this.data = [];
        this.comparator = comparator || ((parent, child) => parent - child);
    }

    get size() {
        return this.data.length;
    }

    bubbleUp(c) {
        if (c === 0) return;
        const p = Math.floor((c + 1) / 2) - 1;
        if (this.comparator(this.data[p], this.data[c]) > 0) {
            [this.data[p], this.data[c]] = [this.data[c], this.data[p]];
        }
        this.bubbleUp(p);
    }

    bubbleDown(p) {
        const c = 2 * (p + 1) - 1;
        if (c >= this.data.length) return;

        const leftDelta = this.comparator(this.data[p], this.data[c]);
        const rightDelta = c + 1 >= this.data.length ? 0 : this.comparator(this.data[p], this.data[c + 1]);
        if (leftDelta <= 0 && rightDelta <= 0) return;

        const swapChildIndex = c + (leftDelta <= rightDelta);
        [this.data[p], this.data[swapChildIndex]] = [this.data[swapChildIndex], this.data[p]];
        this.bubbleDown(swapChildIndex);
    }

    add(val) {
        this.data.push(val);
        this.bubbleUp(this.data.length - 1);
    }

    poll() {
        if (this.size < 2) return this.data.pop();
        [this.data[0], this.data[this.size - 1]] = [this.data[this.size - 1], this.data[0]];
        const val = this.data.pop();
        this.bubbleDown(0);
        return val;
    }
    
    peek() {
        return this.data[0];
    }
}


var findKthLargest = function(nums, k) {
    if (!nums || !nums.length) return 0;
    let heap = new MinHeap();
    for (let i = 0; i < k; i++) {
        heap.add(nums[i]);
    }
    for (let i = k; i < nums.length; i++) {
        if (nums[i] > heap.peek()) {
            heap.poll();
            heap.add(nums[i]);
        }
    }
    return heap.peek();
};
