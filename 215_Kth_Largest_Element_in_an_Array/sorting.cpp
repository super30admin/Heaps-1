#include<bits/stdc++.h>
using namespace std;

/*
Approach: Normal sort and then give kth elem
Time: O(n*logn)
Working on leetcode: Yes
*/

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());
        return nums[nums.size()-k];
    }
};

int main () {
    vector<int> nums{3,2,1,5,6,4};
    int k=2;
    Solution S;
    cout<<S.findKthLargest(nums,k)<<endl;
}