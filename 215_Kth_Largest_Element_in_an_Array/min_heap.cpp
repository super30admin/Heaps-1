#include<bits/stdc++.h>
using namespace std;

/*
Approach: We maintain the potential kth largest elem at top of min heap by maintaining k-1 elems inside heap which are greater that the top. If any elem is greater than the top then we remove the top element and insert current.
Time: O(nlogk)
Working on leetcode: Yes
*/

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> minHeap;
        for(int a: nums) {
            minHeap.push(a);
            if(minHeap.size() > k) {
                minHeap.pop();
            }
        }
        return minHeap.top();
    }
};

int main () {
    vector<int> nums{3,2,1,5,6,4};
    int k=2;
    Solution S;
    cout<<S.findKthLargest(nums,k)<<endl;
}