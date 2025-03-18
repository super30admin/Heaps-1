// Time complexity: O(nlogk)
// Space complexity: O(k)
// Does the code run on Leetcode: Yes

// Approach: 
// - We will use a min heap to store the k largest elements.
// - We will iterate over the array and add elements to the heap.
// - If the size of the heap is less than k, we will add the element to the heap.
// - If the size of the heap is equal to k, we will compare the top element of the heap with the current element.
// - If the current element is greater than the top element of the heap, we will remove the top element and add the current element to the heap.


class Solution {
    public:
        int findKthLargest(vector<int>& nums, int k) {
            priority_queue<int, vector<int>, greater<int>>pq;
            for(int num : nums){
                if(pq.size() < k){
                    pq.emplace(num);
                }
                else{
                    if(num > pq.top()){
                        pq.pop();
                        pq.emplace(num);
                    }
                }
            }
            return pq.top();
        }
    };