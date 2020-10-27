from collections import _heapq

def findKthLargest( self, nums: List[int], k: int) -> int:
    """
    Time Complexity: O(N.Log(N)) height of tree traverse *  creating heap
    Space Complexity: O(N)
    Accepted
    Using heapq library, we can utilize nlargest method _heapq.nlargest(k, nums) as well.
    """
    
    result = []
    #base case
    if not nums or not k or k<0:
        return None

    for i in nums:
        if len(result) > k and i > result[0]:
            _heapq.heapreplace(result, i)
        else:
            _heapq.heappush(result, i)
    return result
