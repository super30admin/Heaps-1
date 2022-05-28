// Time Complexity : O(n*log(n-k+1))
// Space Complexity : O(n-k+1)
//    where n : number of elements in given input vector.
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Build max heap of size (n - k + 1). 
 * Iterate over i/p vector. While iterating add element in priority queue. If priority queue size is greater than (n-k+1) then pop the element from queue. 
 * At the end return the element present at the top of priority queue. 
 */
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> pq;
        
        for (auto& a : nums)
        {
            pq.push(a);
            
            if (pq.size() > (nums.size() - k + 1))
            {
                pq.pop();
            }
        }
        
        return pq.top();
    }
};