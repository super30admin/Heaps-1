//time complexity:O(nlogn)
//space complexity:O(n)
//executed on leetcode: yes
//approach:using priority queueu (min heap)
//any issues faced? no

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>>pq;
        for(int i=0; i<nums.size(); i++)
        {
            pq.push(nums[i]);
            if(pq.size()>k)
                pq.pop();
        }
        return pq.top();
    }
};