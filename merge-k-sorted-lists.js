// Time Complexity : O(NlogK)
// Space Complexity : O(k), not counting the resultant list of length N
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes.  I needed to find someone's implementation of a Heap in JS that was suitable for
// this problem.  Writing this in JS is really hard.

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
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
}

var mergeKLists = function(lists) {
    if (!lists || !lists.length) return null;
    if (lists.length == 1) return lists[0];

    let minHeap = new MinHeap((parent, child) => parent.val - child.val);
    for (const head of lists) {
        minHeap.add(head);
    }
    
    const result = new ListNode(0);
    let cursor = result;
    while (minHeap.size) {
        let min = minHeap.poll();
        cursor.next = min;
        cursor = min;

        if (min.next) minHeap.add(min.next);
    }
    
    return result.next;
};



