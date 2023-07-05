// Time Complexity : O(n)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>
#include <queue>
  
using namespace std; 

class Solution {
public:
    //implement minheap of size k and keep inserting element the end. The element at the top will be kth largest element
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> pq;
        for(int i = 0; i < nums.size(); i++){
            pq.push(nums[i]);
            if(pq.size() > k){
                pq.pop();
            }
        }
        return pq.top();
    }
};