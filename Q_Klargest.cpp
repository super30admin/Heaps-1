
// ## Problem1 
// Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)


//  Approach: Min Heap 
//The idea is to use heap data structure , could be done with max heap - insert all elements and then pop out k
//Time complexity - O(nlogn + klogn), Space complexity - O(n) as n elements in heap
//we can optimise by using a min heap and store only k elements, whenever size increase we pop out an element
// # Time complexity: O(nlogk + logk) 
// # Space complexity: O(k) as k elements in heap



class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        
        //using max heap-->
        //TC O(nlogn + klogn)
        /*
        priority_queue<int> pq; //by default max heap
        for(int i=0; i< nums.size(); i++){
            pq.push( nums[i]);
        }

        int temp=-1;
        while( k){
            int top =pq.top();
            temp = top;
            // cout << top<<endl;
            pq.pop();
            k--;
        }
        return temp;
        */
        
        //using min heap-->
        //TC O(nlogk + logk)
        
        priority_queue <int, vector<int>, greater<int> > pq; //min heap
        
        for(int i=0; i< nums.size(); i++){
            
            pq.push(nums[i]);
            
            if(pq.size() > k){
                pq.pop();
            }
        }
        
        return pq.top();
        
    }
};