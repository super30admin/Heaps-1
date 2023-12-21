/*The function findKthLargest uses a min-heap (priority_queue with a std::greater<int> comparator) to track the k largest elements while iterating through the input array nums.
It adds each element to the min-heap and, if the heap size exceeds k, removes the smallest element.
The result is the top element of the min-heap, which represents the kth largest element in the array.
Time Complexity: O(N log K) - The loop iterates over each element in nums, and each insertion and extraction operation in the min-heap takes log K time, where K is the size of the heap.

Space Complexity: O(K) - The min-heap size is restricted to k, limiting the space usage to the k largest elements.*/
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int,vector<int>,greater<int>> heap;
        for(int num:nums){
            heap.push(num);
            if(heap.size()>k){
                heap.pop();
            }
        }
        return heap.top();
    }
};