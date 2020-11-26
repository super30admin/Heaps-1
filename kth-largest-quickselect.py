# Time Complexity: O(N), O(N^2) - worst case
# Space Complexity: O(1) - not considering recursive stack space
# Approach - Use quickselect to find the Kth largest element - element at index len(nums)-k. More comments in-line
import random


class Solution(object):
    def findKthLargest(self, nums, k):
        # Delegate inputs to helper
        return helper(nums, 0, len(nums)-1, len(nums)-k)


def helper(a, start, end, index):
    # Base Case
    if start == end:
        return a[start]

    # Lomuto's Partitioning
    # Select a random pivot index
    random_pivot_index = random.randint(start, end)
    pivot = a[random_pivot_index]

    # Swap pivot element with first element
    a[random_pivot_index], a[start] = a[start], a[random_pivot_index]

    # initialize two coloring pointers - elements < pivot --> orange, elements > pivot --> green
    orange = start
    green = start

    # Traverse array, if green pointer hits element that's lesser than pivot, increment orange pointer and swap elements
    for green in range(start+1, end+1):
        if a[green] <= pivot:
            orange += 1
            a[orange], a[green] = a[green], a[orange]

    # Get the pivot element to it's right position
    a[orange], a[start] = a[start], a[orange]

    # a[orange]is the pivot element
    # Recursive cases
    # Lucky Case -- if pivot is at the index - kth largest found!
    if orange == index:
        return a[orange]

    # if the index is greater than the pivot, recurse over the right half of the array
    elif orange < index:
        return helper(a, orange+1, end, index)

    # if the index is lesser than the pivot recurse over the left half of the array
    else:
        return helper(a, start, orange-1, index)
