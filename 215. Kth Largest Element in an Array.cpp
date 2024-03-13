/*
Time: O(nlogk) (at once, k most items will be in the heap)
Space: O(k)

Maintain min-heap of size k so that the top element will be smallest of the k elements
Whenever size becomes k+1, pop the min element
*/

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int> > q;

        for(int u: nums){
            q.push(u);

            if(q.size()>k)  q.pop();
        }

        return q.top();
    }
};
