/* 
    Time Complexity                              :  O(N log k) - in the optimized solution
    Space Complexity                             :  O(k) - storing only k elements in the priority_queue 
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/kth-largest-element-in-an-array/

class Solution {
private:
    int n;
public:
    int findKthLargest(vector<int>& nums, int k) {
        n = nums.size();
        int minHeapRes = minHeap(nums,k);
        int maxHeapRes = maxHeap(nums,k);
        
        return minHeapRes;
    }
    
    int minHeap(vector<int>& nums, int k) {
        
        // lambda function to implement the custom comparator to create the min heap
        auto cmp = [](int a, int b){ return a > b; };
        
        priority_queue<int, std::vector<int>, decltype(cmp)> min_heap(cmp);
        for(auto num : nums) {
            min_heap.push(num);
            if(min_heap.size() > k) {
                min_heap.pop();
            }
        }
        return min_heap.top();
    }
    
    int maxHeap(vector<int>& nums, int k) {
        priority_queue<int> max_heap;
        int res = INT_MAX;
        for(auto num : nums) {
            max_heap.push(num);
            if(max_heap.size() > n-k) {
                res = min(res, max_heap.top());
                max_heap.pop();
            }
        }
        
        return res;
    }
};