import heapq

class Solution:
	def kthSmallest1(self, matrix: List[List[int]], k: int) -> int:
		# Time complexity : O(n^2) where n is the size of the matrix
		res = []
		for i in matrix:
			for j in i:
				res.append(j)
		res.sort()
		return res[k - 1]

	def kthSmallest2(self, matrix: List[List[int]], k: int) -> int:
		# Time Complexity : O(klogn)
		# Accepted on leetcode
		# Since rows and columns are in sorted order so we can use a min heap of size equal to the number of columns in the matrix
		# We pop from the priority queue k time and the last value will be our kth smallest element
		queue = []
		for i in range(len(matrix)):
			heapq.heappush(queue, (matrix[i][0], i, 0))
		res = []
		while k > 0:
			val, r, c = heapq.heappop(queue)
			c += 1
			if c < len(matrix[0]):
				heapq.heappush(queue, (matrix[r][c], r, c))
			k -= 1
		return val

	def kthSmallest4(self, matrix: List[List[int]], k: int) -> int:
		# what is the time complexity of this?
		# Similar to the Binary search (which we do it on array)
		left = matrix[0][0]
		right = matrix[-1][-1]
		while left < right:
			mid = left + int((right - left)/2)
			count = self.getCount(matrix, mid)
			if count < k:
				left = mid + 1
			else:
				right = mid
		return left
	
	def getCount(self, matrix, mid):
		count = 0
		j = len(matrix[0]) - 1
		for i in range(len(matrix)):
			while j >= 0 and matrix[i][j] > mid:
				j -= 1
			count += (j + 1)
		return count