#include<bits/stdc++.h>
using namespace std;

/*
Approach: We maintain the (n-k+1) smallest elements. The largest of them would be our answer. T(n): O(nlog(n-k)). This is better when have k comparable to k (n=10000 and k=9999)
Time: O(n*log(n-k))
Working on leetcode: Yes
*/

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> maxHeap;
        for(int a: nums) {
            maxHeap.push(a);
            if(maxHeap.size() > nums.size()-k+1) {
                maxHeap.pop();
            }
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