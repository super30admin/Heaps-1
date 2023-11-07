//Max Heap Solution
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> pq;
        int result = INT_MAX;
        for(int i=0;i<nums.size();i++){
            pq.push(nums[i]);
            if(pq.size()>nums.size()-k){
                int curr = pq.top();
                pq.pop();
                result = min(result, curr);
            }
        }
        return result;
    }
};
//min heap Solution

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> pq;
        for(int i=0;i<nums.size();i++){
            pq.push(nums[i]);
            if(pq.size()>k){
                pq.pop();
            }
        }
        return pq.top();
        
    }
};

