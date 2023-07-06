/*
Time complexity: O(nlog(k))
Space complexity: O(k)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> minHeap;
        for(auto i:nums){
            minHeap.push(i);
            if(minHeap.size()> k) minHeap.pop();
        }
        return minHeap.top();
    }
};