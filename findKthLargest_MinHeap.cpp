// Time Complexity : O(n*log(k))
// Space Complexity : O(k)
//    where n : number of elements in given input vector.
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Build min heap of size k. 
 * Iterate over i/p vector. While iterating add element in priority queue. If priority queue size is greater than (k) then pop the element from queue. 
 * At the end return the element present at the top of priority queue. 
 */

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> pq;
        for (auto a : nums)
        {
            pq.push(a);
            if (pq.size() > k)
                pq.pop();
        }

        return pq.top();
    }
};