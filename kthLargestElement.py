"""
Notes --
Heap is basically a complete binary tree. Based on how the data is stored, heap can be categorized as min heap and
max heap

Heap has the following functions:
parent: (i-1) // 2 where i is the index of element whose parent needs to be found
left child: 2i + 1 where i is the index of element whose left child needs to be found.
right child: 2i + 2 where i is the index of element whose right child needs to be found.
leafNode: for n size heap, leaf nodes are at index i > n/2
add(): add element to the heap
remove(): remove element from the heap
heapify(): heap is generally implemented using array, heapify() is use to arranged the array elements in such a way that it will satisfy the heap data structure's criteria.

Min Heap:
parent < child and root node has the minimum value

Max Heap:
parent > child and root node has the maximum value

When to use heap:
Whenever one needs to find the kth largest element or kth smallest element, then heap is useful.

Approach --
Using minheap
1. Add elements to the heap. Heapify will take place when add() or remove() function is performed
2. If len(heap) is more than k, pop the peek element. Since this is min heap, it'll have min element at the peek,
and we'll thus get kth the largest element in the heap
3. Lastly, return peek element in the heap since it'll be the kth the largest element

TC : O(nlogk) where n is the nos. of elements in the array.
logk is the complexity for heapify function, and we are calling it for every element hence nlog(n)
SC : O(k) as heap will store k elements at a particular time.
"""
import heapq


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # Brute force
        # sortednums = sorted(nums, reverse=True)
        # return sortednums[k-1]
        if nums is None or len(nums) == 0: return None

        heap = []

        for i in nums:
            # heapify taking place when heappush or heappop is called
            heapq.heappush(heap, i)

            if len(heap) > k:
                # this will result in having kth largest element in the heap
                heapq.heappop(heap)

        return heapq.heappop(heap)