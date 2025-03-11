// Time Complexity : O(nLog(k))
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
#include <iostream>
#include <priority_queue>

using namespace std;

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> pq;
        for (int num: nums) {
            pq.push(num);
            if (pq.size() > k) {
                pq.pop();
            }
        }
        
        return pq.top();
    }
};
