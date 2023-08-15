//Time Complexity: O(nlogk)
//Space Complexity: O(k)
class Solution {
public:
    priority_queue<int,vector<int>, greater<int>> pq;
    int findKthLargest(vector<int>& nums, int k) {
        for(int i=0;i<nums.size();i++){
            pq.push(nums[i]);
            if(pq.size()>k){
                pq.pop();
            }
        }
        
        return pq.top();
        
    }
};