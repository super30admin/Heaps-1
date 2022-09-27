'''

## Problem 215: Find kth largest element in the array

## Author: Neha Doiphode
## Date:   09-20-2022


## Description:
    Given an integer array nums and an integer k, return the kth largest element in the array.
    Note that it is the kth largest element in the sorted order, not the kth distinct element.
    You must solve it in O(n) time complexity.

## Examples:
    Example 1:
        Input: nums = [3,2,1,5,6,4], k = 2
        Output: 5

    Example 2:
        Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
        Output: 4

## Constraints:
    1 <= k <= nums.length <= 105
    -104 <= nums[i] <= 104

## Time complexity: Please refer to respective doc-strings of different approaches used below.

## Space complexity: Please refer to respective doc-strings of different approaches used below.

## Design Notes:
    Heap Data structure
        * Binary tree based data structure.
        * Nodes are as left as possible.
        * Complete binary tree where all the levels are filled except the last level.
          A complete binary tree is a binary tree in which all the levels are completely filled except possibly the lowest one,
          which is filled from the left.
          A complete binary tree is just like a full binary tree, but with two major differences.
          All the leaf elements must lean towards the left.
        * Min Heap - Always keeps lowest element at the root. Every node k is smaller than node at 2k + 1 and 2k + 2. Provided indexing is done from 0.
        * Max Heap - Always keeps highest element at the root. Every node k is greater than node at 2k + 1 and 2k + 2. Provided indexing is done from 0.
        *                     1 (0)          - 2^0 nodes max, h = 0
                            /    \
                          4(1)    2(2)       - 2^1 nodes max, h = 1
                         /  \     / \
                        10  6    9   3
                       (3) (4)  (5) (6)      - 2^2 nodes max, h = 2


            Zero-based index array representation: 0 1 2 3  4 5 6
                                            Nodes: 1 4 2 10 6 9 3
                                            left : 2k + 1
                                            right: 2k + 2
                                           parent: index / 2 for odd indices and index / 2 - 1 for even indices.

             One-based index array representation: 1 2 3 4  5 6 7
                                            Nodes: 1 4 2 10 6 9 3
                                            left : 2k
                                            right: 2k + 1
                                           parent: index / 2

        * Insertion: Start inserting elements with the property of "as left as possible".
        * Each insertion in the tree takes log n time. So n such insertions take n log n time.

            For array: 4, 10, 9, 2, 6, 1, 3

            4 |   4   |    4     |    4             4            2       |      2         |     2            2             1       |   1      |
                 /        / \        / \           / \          / \            / \             / \          / \           / \         /  \
                10       10  9      10  9   ===>  2   9   ===> 4   9          4   9           4   9  ===>  4   1   ===>  4   2       4    2
                                    /            /            /              / \             / \  /       / \  /        / \  /      / \  / \
                                   2            10           10             10  6           10 6  1      10  6 9       10  6 9     10  6 9  3


        * Deletion/Extract Min: Replace root node with the last node. Remove the last node. Heapify the tree again to form the Min-Heap.
        * Each deletion in the tree takes log n time. So n such deletions take n log n time.
        * If some middle is to be removed, remove it, replace it with -Inf. Heapify so that -Inf being the smallest goes to the root.
          Once, -Inf goes to root, swap it with last element(Sink down/Sink operation). Remove -Inf from the tree. And Heapify to make sure, min heap is preserved.

                    1                     3                            2
                  /    \                /    \                       /    \
                 4      2        ===>  4      2            ===>     4       3
               /   \  /   \          /   \  /   \                  / \     /
              10   6  9   3         10   6  9   1(remove)         10  6   9

                Choose between smaller element from left and right child.

        * Rules are opposite for the Max heap. Root is the largest value in the tree.
        * Heap sort algorithm: Form Min heap and start extracting elements one by one and form a list to get ascending ordered list in n log n time.


'''

from typing import List, Optional
from queue import PriorityQueue
import heapq


def get_input():
    print("Enter elements(integers) in the array with spaces: ", end = "")
    try:
        nums = input()
    except KeybordInterrupt:
        pass

    nums = [int(num) for num in nums.split()]

    print("Enter the value of k(kth largest element to find): ", end = "")
    k = int(input())
    print()
    return nums, k

class MaxHeapElement:
    def __init__(self, x):
        self.x = x

    def __lt__(self, other):
        return self.x > other.x

    def __le__(self, other):
        return self.x >= other.x

    def __gt__(self, other):
        return self.x < other.x

    def __ge__(self, other):
        return self.x <= other.x


class Solution:
    def __init__(self):
        self._q = PriorityQueue()

    def findKthLargest_using_priority_queue_maxheap(self, nums: List[int], k: int) -> int:
        '''
        Time complexity:  O(n log n), where n is number of elements in the list. To insert an element onto the heap of size n will require log n per element.
                                      We need to insert n such elements, so total time complexity would n log n.
        Space complexity: O(n), we maintain auxiliary queue with n elements.
        '''
        result = -1
        for num in nums:
            self._q.put(MaxHeapElement(num))

        for _ in range(k):
            result = self._q.get().x

        return result

    def findKthLargest_using_heapq_algorithm(self, nums: List[int], k: int) -> int:
        '''
        Time complexity:  O(n log n), where n is number of elements in the list. To insert an element onto the heap of size n will require log n per element.
                                      We need to insert n such elements, so total time complexity would n log n.
        Space complexity: O(1), the input list itself converted into the heap, in-place.
        '''
        heapq.heapify(nums)
        result = -1
        for _ in range(len(nums) - k + 1):
            result = heapq.heappop(nums)
        return result

    def findKthLargest_using_heapq_algorithm_heapify_nlargest(self, nums: List[int], k: int) -> int:
        '''
        Time complexity:  O(n log n), where n is number of elements in the list. To insert an element onto the heap of size n will require log n per element.
                                      We need to insert n such elements, so total time complexity would n log n.
        Space complexity: O(1), the input list itself converted into the heap, in-place.
        '''
        heapq.heapify(nums)
        # n largest takes(n, iterable)
        return sorted(heapq.nlargest(k, nums))[0]

    def findKthLargest_using_min_heap_of_size_k(self, nums: List[int], k: int) -> int:
        '''
        Time complexity: O(n log k), where k is time complexity to insert an element as heap size is always maintained to be/kept at the max k.
                                     n is number of elements.
        Space complexity: O(k), there are always k elements at the max in the list.
        '''
        l = []
        for num in nums:
            heapq.heappush(l, num)
            if len(l) > k:
                heapq.heappop(l)
        return l[0]

    def display(self, l):
        for element in l:
            print(f"{element.x} ", end = "")
        print()

    def findKthLargest_using_max_heap_of_size_n_minus_k(self, nums: List[int], k: int) -> int:
        '''
        Time complexity: O(n log k), where k is time complexity to insert an element as heap size is always maintained to be/kept at the max k.
                                     n is number of elements.
        Space complexity: O(k), there are always k elements at the max in the list.
        '''
        l = []
        n = len(nums) - k
        result = float("inf")
        for num in nums:
            heapq.heappush(l, MaxHeapElement(num))
            if len(l) > n:
                result = min(result, heapq.heappop(l).x)
        return result


# Driver code
solution = Solution()
nums, k = get_input()
nums1 = list(nums)
nums2 = list(nums)
nums3 = list(nums)
nums4 = list(nums)
print(f"Input list: {nums}")
print(f"Input k = {k}")
print()
print(f"Approach 1: Using Max heap: {k}th largest element in the array: {solution.findKthLargest_using_priority_queue_maxheap(nums, k)}", end = "")
print()
print(f"Approach 2: Using Min heap heapq algorithm: {k}th largest element in the array: {solution.findKthLargest_using_heapq_algorithm(nums1, k)}", end = "")
print()
print(f"Approach 3: Using Min heap heapq algorithm and nlargest built-in method: {k}th largest element in the array: {solution.findKthLargest_using_heapq_algorithm_heapify_nlargest(nums2, k)}", end = "")
print()
print(f"Approach 4: Using Min heap of size k: {k}th largest element in the array: {solution.findKthLargest_using_min_heap_of_size_k(nums3, k)}", end = "")
print()
print(f"Approach 5: Using Max heap of size n - k : {k}th largest element in the array: {solution.findKthLargest_using_max_heap_of_size_n_minus_k(nums4, k)}", end = "")
print()
print()
