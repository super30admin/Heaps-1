class Solution:
	def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
		# Time complexity : O(n^2) where n is the size of the matrix
		res = []
		for i in matrix:
			for j in i:
				res.append(j)
		res.sort()
		return res[k - 1]