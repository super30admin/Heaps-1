
// Time Complexity : O(nlog(k))  as we are creating only heap of size k.
// Space Complexity : O(k) for the heap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning



class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
       priority_queue <int, vector<int>, greater<int> > myheap; // inittialize
        
        for( int num:nums){
            myheap.push(num); // loading all elements in to the heap of size k.
            
            if(myheap.size() > k){
                myheap.pop();
            }
        }
        
        int result = myheap.top(); // at the end we will have the heap with k latgest elements, wehre top will be the min. i.e. kth largest.
            
         return result;
        
    }
};