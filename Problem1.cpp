// Time Complexity :O(N log K)
// Space Complexity : O(N - K) if max heap, O(K) if min-heap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Find the K-th Largest element

#include<vector>
#include<queue>
#include<iostream>
using namespace std;


// Using Max heap - size of heap is N - K
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
       
        priority_queue<int> pq;
        
        for(int i = 0; i < nums.size(); i++){
            pq.push(nums[i]);
        }
        
        for(int j = 0; j < k-1; j++){
            pq.pop();
        }
        
        return pq.top();
    }
};


// Using min-heap - size of the heap is K

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        
        priority_queue<int, vector<int>, greater<int>> pq; // using a min-heap
        
        for(int i = 0; i < nums.size(); i++){
            pq.push(nums[i]);
        }
        
        for(int j = 0; j < nums.size() - k; j++){   // size of heap is k here
            pq.pop();
        }
        
        return pq.top();
    }
};