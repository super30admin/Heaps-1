//// Time Complexity :O(nlogk)
// Space Complexity : O(k) //the heap space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//min heap: Construct a min heap of size "K" and remove unwanted top elements.
//Max Heap: Construct a size of heap n-k and maintain top most element to return appropriate result.
class comparator{
public:
    bool operator()(const int &a, const int &b){
        return  b > a;
    }
};


class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        //edge case
        if(nums.size()==0){
            return 0;
        }
        int minimum=INT_MAX;
        //  //max_heap
        priority_queue <int, vector<int>, comparator > pq;
        for(int i=0; i<nums.size();i++){
            pq.push(nums[i]);
            if(pq.size()>(nums.size()-k)){
                minimum= min(pq.top(), minimum);
                pq.pop();
            }
        }
        return minimum;
        
        //min_heap
        // priority_queue <int, vector<int>, comparator > pq;
        // for(int i=0; i<nums.size();i++){
        //     pq.push(nums[i]);
        //     if(pq.size()>k){
        //         pq.pop();
        //     }
        // }
        // return pq.top();
    }
};
