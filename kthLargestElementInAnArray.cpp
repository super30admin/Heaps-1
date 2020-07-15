//Time Complexity-O(nlogk)
//Space Complexity-O(k)
//Runs successfully on leetcode
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        //priority queue for a min heap
        priority_queue<int,vector<int>, greater<int>> pq;
        for(int i =0; i<k; i++)
            pq.push(nums[i]);
        for(int i = k;i <nums.size();i++)
        {
            if(nums[i]>pq.top())
            {
                pq.pop();
                pq.push(nums[i]);
            }
        }
        return pq.top();
        
    }
};