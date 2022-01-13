// Time Complexity : O(nlogk): We loop over n elements and performs extractions of log*k complexity.
// Space Complexity : O(k): heap size
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// first construct a min heap since js does not have a priority queue type ds
// 1, 2, 3, 4, 5, 6, 7 = elements
// 0, 1, 2, 3, 4, 5, 6 = index
var findKthLargest = function (nums, k) {
  class MinHeap {
    constructor() {
      this.heap = [];
      this.size = 0;
      this.limit = k; // will be changed to dynamic variable passed in from fun - TODO
    }

    getParentIndex(index) {
      return Math.floor((index - 1) / 2);
    }

    getLeftChildIndex(index) {
      // if you want left child of 2, you'd do:
      // 2 * 1(index of 2) + 1 = 3. heap[3] is the left child of 2, which is 4
      return 2 * index + 1;
    }

    getRightChildIndex(index) {
      // if you want right child of 2, you'd do:
      // 2 * 1(index of 2) + 2 = 4. heap[4] is the left child of 2, which is 5
      return 2 * index + 2;
    }

    hasParent(index) {
      // will return true if greater than or equal to 0.
      // test case: If you want parent index of element 4:
      // m.f(3-1)/2 = 2/2 = 1 = heap[1] = 2. Parent of 4 is 2.
      // and index is 1 which is greater than 0.
      // Similarly, if we check for 1's parent:
      // m.f(0-1)/2 = -1/2 =  -0.5. m.f(-0.5) = -1. -1 is smaller than zero, hence false
      return this.getParentIndex(index) >= 0;
    }

    hasLeftChild(index) {
      // check for left child of 4
      // 2 * 3 = 6 + 1 = 7. 7 is not less than size - which is 7 -
      // hence, false
      return this.getLeftChildIndex(index) < this.size;
    }

    hasRightChild(index) {
      // check for right child of 4
      // 2 * 3 = 6 + 1 = 7. 7 is not less than size - which is 7 -
      // hence, false
      return this.getRightChildIndex(index) < this.size;
    }

    getParent(index) {
      return this.heap[this.getParentIndex(index)];
    }

    getLeftChild(index) {
      return this.heap[this.getLeftChildIndex(index)];
    }

    getRightChild(index) {
      return this.heap[this.getRightChildIndex(index)];
    }

    swap(index1, index2) {
      let temp = this.heap[index1];
      this.heap[index1] = this.heap[index2];
      this.heap[index2] = temp;
    }

    heapifyUp() {
      let index = this.size - 1;
      // if heapify rule is broken, we start swapping between newly added child and parent.
      // After swap is made, we set the index to that of the parent and check again.
      while (
        this.hasParent(index) &&
        this.getParent(index) > this.heap[index]
      ) {
        this.swap(this.getParentIndex(index), index);
        index = this.getParentIndex(index);
      }
    }

    insert(data) {
      // insert a new node at the end of the heap
      // this.heap.push(node);
      // ^ try above method - TODO
      this.heap.push(data);
      this.size += 1;
      this.heapifyUp();
      // if limit is reached then you need to extract the min which will then heapify down.
      if (this.size > this.limit) {
        this.extractMin();
      }
    }
    extractMin() {
      if (!this.size) return console.log("heap is empty");
      let data = this.heap[0];
      this.heap[0] = this.heap[this.size - 1];
      this.size -= 1;
      this.heap.pop();
      this.heapifyDown();
      return data;
    }

    heapifyDown() {
      let index = 0;
      while (this.hasLeftChild(index)) {
        let smallChildIndex = this.getLeftChildIndex(index);
        if (
          this.hasRightChild(index) &&
          this.getRightChild(index) < this.heap[smallChildIndex]
        ) {
          smallChildIndex = this.getRightChildIndex(index);
        }
        if (this.heap[index] < this.heap[smallChildIndex]) {
          break;
        } else {
          this.swap(index, smallChildIndex);
          index = smallChildIndex;
        }
      }
    }
  }
  const minHeap = new MinHeap();
  for (let i = 0; i < nums.length; i++) {
    minHeap.insert(nums[i]);
  }
  return minHeap.heap[0];
};

findKthLargest([3, 2, 1, 5, 6, 4], 1);
