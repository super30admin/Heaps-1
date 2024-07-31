#I used the Quickselect algorithm for its efficiency. The algorithm starts by randomly selecting a pivot from the list and partitioning the list into two sublists: one with elements less than the pivot (L) and one with elements greater than the pivot (R). The algorithm then checks the size of R. If R contains at least k elements, it recursively searches R because the k-th largest element must be in that sublist. If the size of R plus the number of elements equal to the pivot is at least k, the pivot is the k-th largest element. Otherwise, it recursively searches L, adjusting k to account for the elements in R and the pivot. This method effectively reduces the problem size at each step, leading to an average time complexity of O(N) and a worst-case time complexity of O(N^2), where N is the number of elements in the list. The space complexity is O(N) due to the recursive calls and the additional space required for the sublists.

class Solution:
    def findKthLargest(self, nums: List[int], t: int) -> int:
        def quickslect(A, k):
            P = random.choice(A)
            L, R = [a for a in A if a < P], [a for a in A if a > P]
            if len(R) >= k:
                return quickslect(R, k)
            elif len(A)-len(L) >= k:
                return P
            else:
                return quickslect(L, k - (len(A) - len(L)))

        return quickslect(nums, t)