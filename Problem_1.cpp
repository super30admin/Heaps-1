/**
 * Time Complexity:
 * In case of the min heap the time complexity will be O(n(logk)) where n is the number of
 * elements in the array.
 * 
 * In case of max heap it will be O(nlog(n-k))
 * 
 * As we are assuming k <<< n, so we prefer min heap solution
 * 
 */

/**
 * Space Complexity:
 * As we are prefering min heap, so the space complexity in that case will be O(k).
 */

/**
 * Approach:
 * The first inution is sort it and find the element at k-1th index. But this solution
 * is not optimized. The time complexity for that solution will be O(nlogn) and space complexity
 * will be O(1). To improve the time complexity we think of heap. The intution is heaps always
 * heapify which means for max heap the max element will always be at the top and 
 * for min heap the minimum element will be at the top. But we need the kth largest element
 * so we have to perform an operation which gives kth largest element at the top.
 * 
 * Based on this intution we can think that if we maintain a heap of size k where whenever the
 * size of the heap becomes greater than k we pop the element from the top, we will get our
 * answer. In case of max heap we will push all the elements in the heap first and then
 * run k-1 iterations starting from zero to pop the top element to get the kth largest number.
 * Here the idea is we will have all the elements in the heap with max at the top.
 * Then we will remove k-1 times the top element, after that the top element will be our 
 * answer. In case of min heap, we will keep pushing the elements in the heap and heapify will
 * be performed, whenever the size of heap becomes greater than k we will pop the top element.
 * At the end we will have the kth largest element at the top and the largest element at the
 * bottom.
 * 
 */

// The code ran perfectly on leetcode

//Max Heap
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> pq(nums.begin(), nums.end());
        for(int i =0;  i < k-1; i++){
                pq.pop();
            }
        
        return pq.top();
        
    }
};

//Min Heap
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> pq;
        for(auto num: nums){
            pq.push(num);
            if(pq.size() > k){
                pq.pop();
            }
        }
        
        return pq.top();
        
    }
};