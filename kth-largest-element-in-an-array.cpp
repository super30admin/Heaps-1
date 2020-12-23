// Time Complexity: O(nlogn) where n = size of nums, size of priority queue will be 'k'
//  n for for loop and log k for heapify while pushing an element into priority queue
// Space Complexity: O(k)
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> pq;
        for(int i = 0; i < nums.size(); i++) {
            if(pq.size() == k) {
                if(pq.top() < nums[i]) {
                    pq.pop();
                    pq.push(nums[i]);
                }
            }
            else {
                pq.push(nums[i]);
            }
        }
        
        return pq.top();
    }
};
