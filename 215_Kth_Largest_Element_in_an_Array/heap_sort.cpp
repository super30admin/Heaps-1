#include<bits/stdc++.h>
using namespace std;

/*
Approach: Insert all n elems in heap and then remove k-1 elems
Time: O(n*logn)
Working on leetcode: Yes
*/

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> maxHeap;
        for(int a: nums) {
            maxHeap.push(a);
        }
        while(k>1) {
            maxHeap.pop();
            k--;
        }
        return maxHeap.top();
    }
};

int main () {
    vector<int> nums{3,2,1,5,6,4};
    int k=2;
    Solution S;
    cout<<S.findKthLargest(nums,k)<<endl;
}