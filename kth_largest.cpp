//TC: O(Nlogk)
//SC: O(k)

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
   
        //construct a minheap such that it has the "k" largest elements only.
        priority_queue<int, vector<int>, greater<int>> minHeap;
        
        for(int i=0; i<nums.size(); i++){
            minHeap.push(nums[i]);

            if(minHeap.size() > k)
                minHeap.pop();

        }
        
        return minHeap.top();
        
//         //brute force using maxHeap. Time: NlogN
//         priority_queue<int> maxHeap;
        
//         for(int i=0; i<nums.size(); i++)
//             maxHeap.push(nums[i]);
        
//         int i =0;
//         int largest = 0;
//         while(k>0){
//             largest = maxHeap.top();
//             maxHeap.pop();            
//             k--;
//         }
        
//         return largest;
        
    }
};