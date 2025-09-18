#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We use bucket sort by counting how often each number appears between min and max.
Then we go from the biggest bucket down, subtracting until we reach the k-th largest.
The position where remain drops to 0 gives us the answer.
*/
class Solution{
public:
    int kthLargestElement(vector<int>& nums, int k){
        int min = INT_MAX;
        int max = INT_MIN;

        for(int num : nums){
            if(num < min) min = num;
            if(num > max) max = num;
        }

        vector<int> count(max-min+1, 0);
        for(int num : nums) count[num - min]++;

        int remain = k;
        for(int num=count.size()-1; num>=0; num--){
            remain -= count[num];
            if(remain <= 0) return num + min;
        }
        return -1;
    }
};
