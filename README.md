# Heaps-1

## Problem1: Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)
class Solution:
    def findKthLargest(self, nums, k):
        left, right = 0, len(nums) - 1
        while True:
            pivot_index = random.randint(left, right)
            new_pivot_index = self.partition(nums, left, right, pivot_index)
            if new_pivot_index == len(nums) - k:
                return nums[new_pivot_index]
            elif new_pivot_index > len(nums) - k:
                right = new_pivot_index - 1
            else:
                left = new_pivot_index + 1

    def partition(self, nums, left, right, pivot_index):
        pivot = nums[pivot_index]
        nums[pivot_index], nums[right] = nums[right], nums[pivot_index]
        stored_index = left
        for i in range(left, right):
            if nums[i] < pivot:
                nums[i], nums[stored_index] = nums[stored_index], nums[i]
                stored_index += 1
        nums[right], nums[stored_index] = nums[stored_index], nums[right]
        return stored_index


## Problem2: Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)
def mergeKLists_Python3(self, lists):
	ListNode.__eq__ = lambda self, other: self.val == other.val
	ListNode.__lt__ = lambda self, other: self.val < other.val
	h = []
	head = tail = ListNode(0)
	for i in lists:
		if i:
			heapq.heappush(h, (i.val, i))

	while h:
		node = heapq.heappop(h)[1]
		tail.next = node
		tail = tail.next
		if node.next:
			heapq.heappush(h, (node.next.val, node.next))

	return head.next
