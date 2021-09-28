// Time Complexity : O(nlog(n- k))
// Space Complexity : O(n-k)
// Did this code successfully run on Leetcode : Yes
// Approach : Implemented a max heap priority queue
// We iterate over every element and add it to the queue until length is (n-k)
//We remove the max element and compare it with the prev max returning the kth largest element

var findKthLargest = function (nums, k) {
    let pq = new PriorityQueue((a, b) => b - a);
    let result = Infinity;
    for (let num of nums) {
        pq.add(num);
        if (pq.size > nums.length - k) {
            result = Math.min(pq.poll(), result);
        }
    }
    return result;
};

class PriorityQueue {
    constructor(comparator) {
        this.data = [];
        this.comparator = comparator || ((parent, child) => parent - child);
    }

    get size() {
        return this.data.length;
    }

    add(val) {
        this.data.push(val);
        this.bubbleUp(this.data.length - 1);
    }

    poll() {
        if (this.size < 2) return this.data.pop();

        [this.data[0], this.data[this.data.length - 1]] = [this.data[this.data.length - 1], this.data[0]];
        const val = this.data.pop();
        this.bubbleDown(0);
        return val;
    }

    peek() {
        return this.data[0];
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

        const leftChild = this.comparator(this.data[p], this.data[c]);
        const rightChild = c + 1 >= this.data.length ? 0 : this.comparator(this.data[p], this.data[c + 1]);
        if (leftChild <= 0 && rightChild <= 0) return;

        const swapChildIndex = c + (leftChild <= rightChild);
        [this.data[p], this.data[swapChildIndex]] = [this.data[swapChildIndex], this.data[p]];
        this.bubbleDown(swapChildIndex);
    }
}