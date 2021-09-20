//TC - O(nlogn)
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int>q;
        int i,n=nums.size();
        for(i=0;i<n;i++){
            q.push(nums[i]);
        }
        i=0;
        while(i<k){
            if(i==k-1)
                break;
            q.pop();
            i++;
        }
        return q.top();
    }
};