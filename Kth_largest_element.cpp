//Min Heap Solution
//Time Complexity-O(n*logk)--->'n' is number of nodes and 'k' is given in the input as kth largest element
//Space Complexity-O(k)
//Did the code run on Leetcode? yes

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        if(nums.size()==0)
        {
            return 0;
        }
        priority_queue<int,vector<int>,greater<int>>m;
        for(int i=0;i<nums.size();i++)
        {
            if(m.size()<k)
            {
                m.push(nums[i]);
            }
            else
            {
                if(nums[i]>m.top())
                {
                    m.pop();
                    m.push(nums[i]);
                }
            }
        }
        return m.top();
    }
};