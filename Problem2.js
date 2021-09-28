// Time Complexity : O(nklog(k))
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Approach : Implemented a min heap priority queue
//We iterate over the lists array and add all the nodes to the queue
//Will create a new linked list and add the min val from the lists node to the new linked list
//will move to the next node of the last polled node
//continue till all the values are polled and added to the dummy linked list
//finally return the head of the dummy i.e dummy.next

var mergeKLists = function (lists) {
    let pq = new PriorityQueue((a, b) => a.val - b.val);
    let dummy = new ListNode(-1);
    let current = dummy;
    for (let node of lists) {
        if (node) {
            pq.add(node);
        }
    }
    while (pq.size) {
        let min = pq.poll();
        current.next = min;
        current = current.next;
        if (min.next != null) {
            pq.add(min.next);
        }
    }
    return dummy.next;
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