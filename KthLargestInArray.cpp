
//Time Complexity O(nlogn)
// Space Complexity O(n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;


class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> pq;
        for(auto &num : nums)
        {
            pq.push(num);
            if(pq.size()>k)
            {
                pq.pop();
            }
        }
        return pq.top();
    }   
};