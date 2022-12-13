// Time Complexity : O(n log k) n times inserting into heap of size k
// Space Complexity : O (k) - heap of size k
// Did this code successfully run on Leetcode : Yes 

// APPROACH 1: Min heap of size k 

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        // Min heap solution of size k
        // this removes the elements smallest and holds only k largest elements in the heap
        
        priority_queue<int, vector<int>, greater<int>> pq;

        for(int n:nums){
            pq.push(n);
            if(pq.size() > k)
                pq.pop();
            }
        return pq.top();
    }
};


//Approach 2: Max heap of size n-k
// Time Complexity : O(n log (n-k))
// Space Complexity : O (n-k) 
// Did this code successfully run on Leetcode : Yes 

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        // Max heap solution of size n-k
        // this removes the elements biggest element and holds only n-k smallest element
        // we keep the result in another variable

        priority_queue<int> pq;
        int result = INT_MAX;

        for(int n:nums){
            pq.push(n);
            if(pq.size() > (nums.size()-k)){
                result = min(result, pq.top());
                pq.pop();
            }
        }
        return result;
    }
};