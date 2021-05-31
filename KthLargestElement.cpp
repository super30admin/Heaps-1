/*
Intuition: 

Solution 1) Use min heap. If I have a min heap of k and pop out min elements, I will have only k maximum elements remainig.
Solution 2) Use max heap of size n-k. If I have a max heap of n-k and pop out max elements, I will get the kth max.
#####################################################################
Solution 1:
Time Complexity : O(n log (k)) 
Space Complexity : O(k)
#####################################################################
Solution 2:
Time Complexity : O(n log (n-k)) 
Space Complexity : O(k)
#####################################################################
*/

struct compareValues{
    bool operator()(int i, int j){
        //Min heap
        return i > j;
    }
};
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        
        priority_queue<int, vector<int>, compareValues> pq;
        
        for ( auto num: nums){
            
            pq.push(num);
            if (pq.size()>k){
                pq.pop();
            }
        }
        return pq.top();
        
    }
};


struct compareValues{
    bool operator()(int i, int j){
        //Max heap
        return i < j;
    }
};
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        int n = nums.size();
        priority_queue<int, vector<int>, compareValues> pq;
        int result = INT_MAX;
        for ( auto num: nums){
            
            pq.push(num);
            if (pq.size()>n-k){
                int potentialResult = pq.top();
                result = min(potentialResult, result );
                pq.pop();
            }
        }
        return result;
        
    }
};

