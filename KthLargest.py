# TC - O(n log k)
# SC - O(k)
# Implemented max heap for practise instead of using library.
class Heap(object):
    def __init__(self):
        self.heap = []

    def getParent(self, pos):
        return (pos - 1) // 2

    def isValidIndex(self, pos):
        return pos >= 0 and pos < len(self.heap)

    def insert(self, element):
        self.heap.append(element)
        index = len(self.heap) - 1
        while self.isValidIndex(self.getParent(index)) and self.heap[self.getParent(index)] < self.heap[index]:
            self.heap[self.getParent(
                index)], self.heap[index] = self.heap[index], self.heap[self.getParent(index)]
            index = self.getParent(index)

    def swap(self, pos1, pos2):
        self.heap[pos1], self.heap[pos2] = self.heap[pos2], self.heap[pos1]

    def remove(self):
        element = self.heap[0]
        self.swap(len(self.heap) - 1, 0)
        self.heap.pop()
        self.bubbledown(0)
        return element

    def size(self):
        return len(self.heap)

    def getLeftChild(self, pos):
        return 2 * pos + 1

    def getRightChild(self, pos):
        return 2 * pos + 2

    def bubbledown(self, pos):
        left_child = self.getLeftChild(pos)
        right_child = self.getRightChild(pos)

        if self.isValidIndex(left_child) and self.isValidIndex(right_child):

            if (self.heap[pos] < self.heap[left_child] or self.heap[pos] < self.heap[right_child]):
                if self.heap[left_child] > self.heap[right_child]:
                    self.swap(left_child, pos)
                    self.bubbledown(left_child)
                else:
                    self.swap(right_child, pos)
                    self.bubbledown(right_child)
        elif self.isValidIndex(left_child):
            if self.heap[left_child] > self.heap[pos]:
                self.swap(left_child, pos)
                self.bubbledown(left_child)

    def peek(self):
        return self.heap[0]


class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        heaps = Heap()
        for num in nums:
            heaps.insert(num)
            if heaps.size() > len(nums) - k + 1:
                heaps.remove()

        return heaps.peek()
