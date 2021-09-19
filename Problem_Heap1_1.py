class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        k = len(nums) - k
        def quickSelect(left, right):
            pivot, pointer = nums[right], left
            for i in range(left, right):
                if nums[i] < pivot:
                    nums[i], nums[pointer] = nums[pointer], nums[i]
                    pointer += 1
            nums[pointer], nums[right] = nums[right], nums[pointer]
            if pointer == k: return nums[pointer]
            if pointer > k: return quickSelect(left, pointer -1)
            else: return quickSelect(pointer + 1, right)
        return quickSelect(0, len(nums) - 1)


# TC : O(n)
#SC  : O(1)
