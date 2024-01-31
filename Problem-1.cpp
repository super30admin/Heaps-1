// Time Complexity : O(Nlog k) where log k - heapifying k elements and N - N elements

// Space Complexity : O(k)

// Did this code successfully run on Leetcode : Yes

// Appoarch: Created a min heap (priority queue), iterated through the array and
// added them to PQ. IF size of PQ is greater k pop the elements from the PQ. 

// 215. Kth Largest Element in an Array

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> pq;
        for(int num:nums){
            pq.push(num);
            if(pq.size() > k){
                pq.pop();
            }
        }
        return pq.top();
    }
};