//Max heap Solution
//Time Complexity-O(k*logn)-->'n' is number of nodes and 'k' is given in input as kth largest element
//space Complexity-O(n)
//Did the code run on Leetcode? yes

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        if(nums.size()==0)
        {
            return 0;
        }
        priority_queue<int,vector<int>>m;
        for(int i=0;i<nums.size();i++)
        {
            m.push(nums[i]);
        }
        for(int i=0;i<k-1;i++)
        {
            m.pop();
        }
        return m.top();
    }
};