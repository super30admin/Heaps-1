#include <iostream>
#include <vector>
#include <queue>
using namespace std;
// Function to find the kth largest element in an array using a min-heap
int findKthLargest(vector<int>& nums, int k) {
    priority_queue<int,vector<int>,greater<int>>min_heap;
    int n = nums.size();
    for(int i=0;i<=n-1;i++){
        if(i<k) min_heap.push(nums[i]);
        else{
            if(nums[i]>min_heap.top()){
                min_heap.push(nums[i]);
                min_heap.pop();
            }
        }
    }
    return min_heap.top();
}
int main() {
    vector<int>nums = {3,2,1,5,6,4};
    int k = 2;
    int result = findKthLargest(nums, k);
    cout << "The " << k << "th largest element is: " << result << endl; // Output: 5
    return 0;
}
// Time Complexity: O(k)+O((n-k)log k)
// Space Complexity: O(k)
//Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Maintaining a min heap to find the top k elements, and after iterating throughout the array, the final top of the min heap will be the kth largest element. 