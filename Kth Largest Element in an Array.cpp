//min heap of k elements - return top
// OR max heap of (n-k+1) elements
//time: O(nlogk)
// space: O(k)
// min heap:
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> pq;
        for(int i = 0; i < nums.size(); i++) {
            pq.push(nums[i]);
            if(pq.size() > k) {
                pq.pop();
            }
        }
        return pq.top();
    }
};

// max heap:
/*
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> pq;
        for(int i = 0; i < nums.size(); i++) {
            pq.push(nums[i]);
            if(pq.size() > (nums.size()-k+1)) {
                pq.pop();
            }
        }
        return pq.top();
    }
};
*/