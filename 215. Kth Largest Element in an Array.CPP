class Solution {
public:
//     Time complexity : O(Nlogk).
// Space complexity : O(k) to store the heap elements.
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int,vector<int>,greater<int>> heap;
        for(auto num:nums){
            heap.push(num);
            if(heap.size()>k)heap.pop();
        }
        
return heap.top();
        
    }
};