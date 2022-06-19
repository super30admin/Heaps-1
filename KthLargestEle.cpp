
Find the kth largest element
----------------------------------------------------------
Using min heap

O(nlogk)time, O(K) space

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> pq;
        for(int i=0;i<nums.size();i++){
            pq.push(nums[i]);
            if(pq.size()>k) pq.pop();
        }
        return pq.top();
    }
};

Using Max Heap

O(nlog(n-k))time, O(n-k) space

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> pq;
        int result = INT_MAX;
        int n = nums.size();
        for(int i=0;i<n;i++){
            pq.push(nums[i]);
            if(pq.size()>n-k) {
                result = min(result,pq.top());
                pq.pop();
            }
        }
        return result;
    }
};
