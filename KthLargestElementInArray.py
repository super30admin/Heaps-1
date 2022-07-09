#TC:O(nlogk)
#SC:O(k+1)

import heapq
class Solution:
    def findKthLargest(self, nums, k):
        myList = nums[:k]
        heapq.heapify(myList) # convert first k nums to the max heap
        for i in range(k, len(nums)):
            heapq.heappushpop(myList, nums[i]) # push remaining nums
        return myList[0]

#code explaining heaps in py using __lt__
'''
import heapq

class Node(object):
    def __init__(self, val: int):
        self.val = val

    def __repr__(self):
        return f'Node value: {self.val}'

    def __lt__(self, other):
        return self.val < other.val

heap = [Node(2), Node(0), Node(1), Node(4), Node(2)]
heapq.heapify(heap)
print(heap)  # output: [Node value: 0, Node value: 2, Node value: 1, Node value: 4, Node value: 2]

heapq.heappop(heap)
print(heap)  # output: [Node value: 1, Node value: 2, Node value: 2, Node value: 4]
'''
#
'''

'''