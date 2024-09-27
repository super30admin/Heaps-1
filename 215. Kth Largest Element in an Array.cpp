/*
Min Heap Approach
Time Complexity = O(NLog k)
Space Complexity = O(K)
where N is the number of elements in the array and k is the height of the heap.
log k is the time complexity coming due to the heapify of new element. i.e- when we arrange the new element in the heap such that it follows the Min heap property.
*/
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue <int, vector<int>, greater<int>> pq;
        for(int i = 0; i<nums.size();i++)
        {
            pq.push(nums[i]);
            if(pq.size()>k)
                pq.pop();
        }
        return pq.top();
    }
};


/*
Max Heap Approach
Time Complexity = O(NLog k)
Space Complexity = O(N-K)
where N is the number of elements in the array and k is the height of the heap.
*/
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue <int> pq;
        int result = INT_MAX;
        for(int i = 0; i<nums.size();i++)
        {
            pq.push(nums[i]);
            if(pq.size()>nums.size()-k){
                result = min(result, pq.top());
                pq.pop();
            }
        }
        return result;
    }
};
