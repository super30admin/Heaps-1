'''
215 Kth Largest Element in an Array
https://leetcode.com/problems/kth-largest-element-in-an-array/description/

Given an integer array nums and an integer k, return the kth largest element in the array. Note that it is the kth largest element in the sorted order, not the kth distinct element. Can you solve it without sorting?

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Constraints:
1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104

Solution:
1. Sorting: Sort the array and pick the element at (k-1)th index
Time: O(N log N), Space: O(1) (assume in-place sorting)

2. Linear Search: Read the array and pick the highest element. Mark the highest element as visited. Time spent is O(N). Read the array (except the visited elements) and pick the 2nd highest element. Mark the 2nd highest element as visited. Time spent is another O(N). And so on. Thus, for kth highest element, time spent =
O(N) + O(N) + ... K times = KO(N) = O(NK)
Time: O(NK), Space: O(1)

3. Max heap: Heapify all the elements in the array and pop the binary heap K times. Time: O(N log N + K log N) = O((N+K) log N), Space: O(N) (space since the heap is stored in a new array)

4. Min heap: Heapify all the elements in the array. Thus, the first N-K elements popped from the array would be the N-K values smaller than Kth largest. Array = [<-- N-K elements -->, <-- K elements -->]. The next element popped after popping N-K elements would be the Kth largest element.

Time: O(N log N + (N-K+1) log N) = O((2N-K+1) log N), Space: O(N) (space since the heap is stored in a new array)

5. Min heap of size K: Create a min heap by adding only K elements from the array. In order to add the remaining N-K elements to the heap one-by-one while maintaining the size of heap as K, we must lose N-K elements from the heap. Thus, add the next element from the array (size becomes K+1). Since size has exceeded K, remove the root element (min element) from the heap. Thus, each time we add an element from the remaining elements from the array, we lose the min element from the heap. For adding N-K elements, we lose N-K min elements from the top (root). We are left with remaining K elements in the heap which are the K largest elements. The root of the heap is the Kth largest element.

Rule of Thumb: To find kth largest, use min heap of size k
               To find kth smallest, use max heap of size k

https://youtu.be/PcrRJAwruKg?t=2493
Time: O(K log K + (N-K) log K) = O(N log K), Space: O(K)


6. Max heap of size N-K: This technique is complementary to the min heap of size K technique. When we construct a max heap of size N-K, we save the max elements out of the first N-K elements on the top of the heap. In order to add the remaining K elements to the heap, we must sacrifice K elements from the heap. Which elements do we sacrifice? Elements at the top of the heap. And top of the heap elements are the K largest elements that we have to let go. The min of the K largest elements is the Kth largest element whereas the heap is left with N-K min elements.

Let m = inf. Create a max heap tree by adding only N-K elements from the array. For the remaining K elements, add the next element from the array (size becomes K+1). Since size has exceeded K, remove the root element (max element) from the heap. Store m=min(m, max element). Thus, each time we add an element from the remaining elements from the array, we lose the max element from the heap.

Rule of Thumb:
To find the kth largest element, use (a) or (b).
a) min heap of size k. kth largest element is preserved at the top of heap
b) max heap of size N-k. kth largest element is the min of the elements popped/lost from the heap.

To find the kth smallest elemet, use (a) or (b).
a) max heap of size k. kth smallest element is preserved at the top of heap
b) min heap of size N-k. kth smallest element is the max of the elements popped/lost from the heap.

https://youtu.be/PcrRJAwruKg?t=3340
Time: O((N-K) log (N-K) + K log (N-K)) = O(N log N-K), Space: O(N-K)

'''

# We implement Solution #3, #5 and #6 below

import heapq

def findKthLargest_maxheap_full(nums, k):
    ''' Max heap of size N (N = len(nums)) '''
    N = len(nums)
    heap = [None]*N
    for i in range(N):
        heap[i] = -nums[i]
    heapq.heapify(heap) # heapify entire array
    for _ in range(k-1): # pop k-1 times
        heapq.heappop(heap)
    return -heap[0] # peek, same as popping the kth time

def findKthLargest_minheap(nums, k):
    ''' Min heap of size K '''
    N = len(nums)
    heap = []
    heapq.heapify(heap)
    for num in nums:
        if len(heap) < k:
            heapq.heappush(heap, num)
        else: # len(heap) == k:
            heapq.heappushpop(heap, num)
    # at this point, heap should contain the k largest elements
    # with heap[0] being the kth largest.
    return heap[0]

def findKthLargest_maxheap(nums, k):
    ''' Max heap of size N-K '''
    N = len(nums)
    m = float('-inf')
    heap = []
    heapq.heapify(heap)
    for num in nums:
        num = -num # negate so that min heap behaves like max heap
        if len(heap) < N-k:
            heapq.heappush(heap, num)
        else: #len(heap) == N-k:
            popped = heapq.heappushpop(heap, num)
            m = max(m,popped)
    return -m

def run_findKthLargest():
    tests = [([3,2,1,5,6,4], 2, 5),
             ([3,2,3,1,2,4,5,5,6], 4, 4),]
    for test in tests:
        nums, k, ans = test[0], test[1], test[2]
        print(f"\nArray = {nums}")
        print(f"K = {k}")
        for method in ['minheap_full','minheap','maxheap']:
            if method == 'minheap_full':
                result = findKthLargest_maxheap_full(nums, k)
            elif method == "minheap":
                result = findKthLargest_minheap(nums, k)
            elif method == "maxheap":
                result = findKthLargest_maxheap(nums, k)
            print(f"{method}: Result = {result}")
            success = (ans == result)
            print(f"Pass: {success}")
            if not success:
                return

run_findKthLargest()