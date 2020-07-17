//Time Complexity : O(nlog(n-k))
// Space Complexity :O(n-k)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    
    int findKthLargest(vector<int>& nums, int k) {
        // min heap priority_queue<int,vector<int>,greater<int>> pq;
        //default max heap priority_queue<int> pq;
        //uisng max heap 
        /*int min = INT_MAX;
        for(int i=0; i<nums.size(); i++){
            pq.push(nums[i]);
            if(pq.size()>(nums.size()-k)){
                if(pq.top()<min)
                    min = pq.top();
                pq.pop();
            }
        }
        
        return min;*/
        
        //using min heap
        //Time Complexity : O(nlogk)
        // Space Complexity :O(n)
        priority_queue<int,vector<int>,greater<int>> pq;
        for(int i=0; i<nums.size(); i++){
            pq.push(nums[i]);
            if(pq.size()>k)
                pq.pop();
        }
        
        return pq.top();
        
        
        
    }
};