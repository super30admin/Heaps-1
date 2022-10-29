// Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)

// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// nums =  1,2,3,4,5,6,7
// index = 0,1,2,3,4,5,6
// Parent = floor (n-1)/2
// Child1 = n*2+1; n*2+2

class minHeap {
    constructor() {
        // Initialise the array
        this.heap = [];
    }
    swap(a, b) {
        let temp = this.heap[a];
        this.heap[a] = this.heap[b];
        this.heap[b] = temp;
    }
    insert(num) {
        // Add at end
        this.heap.push(num);
        let idx = this.heap.length - 1;
        let parentIdx = Math.floor((idx - 1) / 2);

        // Compare with parent and bubble up
        while (parentIdx >= 0 && this.heap[parentIdx] > this.heap[idx]) {
            this.swap(parentIdx, idx);
            idx = parentIdx;
            parentIdx = Math.floor((idx - 1) / 2);
        }
    }
    delete() {
        // Swap 1st and last
        this.swap(0, this.heap.length - 1);
        // Remove last
        let removedEle = this.heap.pop();
        // Bubble down the 1st
        let idx = 0;
        let n = this.heap.length;
        while (true) {
            let child1 = (idx * 2) + 1;
            let child2 = (idx * 2) + 2;
            if (child1 >= n) {
                break;
            }
            if (Math.min(this.heap[child1],
                this.heap[child2] || Number.MAX_SAFE_INTEGER) > this.heap[idx]) {
                break;
            }
            if (this.heap[child2] !== undefined && this.heap[child2] < this.heap[child1]) {
                this.swap(child2, idx);
                idx = child2;
            } else {
                this.swap(child1, idx);
                idx = child1;
            }
        }
        return removedEle;
    }
}

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function (nums, k) {
    // Create a minHeap of length k
    // Last element in the array will be the answer   
    let mh = new minHeap();
    let i = 0;
    while (i < nums.length) {
        mh.insert(nums[i]);
        if (mh.heap.length > k) {
            mh.delete();
        }
        i++;
    }
    return mh.heap.slice(0, 1);
};