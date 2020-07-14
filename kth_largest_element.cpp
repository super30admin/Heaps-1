//Time Complexity-O(nlogk)
//Space Complexity-O(k)
//Ran successfully on leetcode
//3 point algo -
	//1.Add k elements to priority queue with min heap implementation
	//2.For every element pushed into the queue, the heapify function takes place and we get the min on top.
	//3.Pop out the top of the queue if it is greater than the incoming element. Finally we have the kth largest element at the top.

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        //Initiate a priority queue for a min heap
        priority_queue<int, vector<int>, greater<int>>q;
        for(int i=0;i<k;i++)
            q.push(nums[i]);
        for(int i=k;i<nums.size();i++)
        {
            if(nums[i]>q.top())
            {
                q.pop();
                q.push(nums[i]);            
            }
        }
        return q.top();
    }
};