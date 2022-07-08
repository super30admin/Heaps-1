// MinHeap
// Time Complexity -> O(n*logk).
// Space Complexity -> O(k)
// Problems faced - NO!
// It runs on Leetcode!

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> pq;
        for(int num : nums){
            pq.push(-num);				// This is O(logk)
            if(pq.size() > k)
                pq.pop();
        }
        return -pq.top();
    }
};

// Using 'greater' as comparision function.
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> pq;
        for(int num : nums){
            pq.push(num);				// This is O(logk)
            if(pq.size() > k)
                pq.pop();
        }
        return pq.top();
    }
};

// MaxHeap
// Time Complexity -> O(n*log(n-k)).
// Space Complexity -> O(n-k)
// Problems faced - NO!
// It runs on Leetcode!
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        int n = nums.size();
        priority_queue<int> pq;
        int answer = INT_MAX;
        int temp;
        for(int num : nums){
            pq.push(num);
            if(pq.size() > n-k){
                answer = min(answer, pq.top());
                pq.pop();
            }
            //cout << answer << endl;
        }
        return answer;
    }
};