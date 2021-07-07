//Time : O(nlogn)
//Space : O(n)

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
         priority_queue<int> pq;
        for(auto i:nums){
            pq.push(i);
        }
        while(k>1){
            pq.pop();
            k--;
        }
        return pq.top();
    }
};
