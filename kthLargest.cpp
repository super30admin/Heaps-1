// Time Complexity : O(n); n = size of array
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Create a max-heap and add all elements of array in it
// 2. Pop k-1 elements out of it and return the kth element as result

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> pq(nums.begin(), nums.end());
        while(k>1){
            pq.pop();
            k--;
        }
        return pq.top();
    }
};


// Time Complexity : O(n); n = size of array
// Space Complexity : O(k) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. kth largest in n elements is same as smallest of the k largest elements
// 2. Create a min-heap and add elements to it till size of heap reaches k
// 3. Now, add new element only if its greater than top of heap. Finally return top of heap

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> pq;
        for(auto el: nums){
        	if(pq.size()<k)
        		pq.push(el);
        	else if(el>pq.top()){
        		pq.pop();
        		pq.push(el);
        	}
        }
        return pq.top();
    }
};

