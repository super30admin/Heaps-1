// Time Complexity: O(nlogk)
// Space Complexity: O(k)
// Does the code run on Leetcode: Yes

// Approach:
// Use a min heap to store the heads of the linked lists.
// Iterate over the linked lists and add the heads to the heap.
// Pop the top element from the heap and add it to the result linked list.
// If the popped element has a next element, add it to the heap.
// Continue this process until the heap is empty.

struct Compare{
    bool operator()(ListNode* a, ListNode* b){
        return a -> val > b -> val;
    }
};
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<ListNode*, vector<ListNode*>, Compare>pq;
        for(auto head : lists){
            if(head != nullptr){
                pq.emplace(head);
            }

        }
        ListNode* dummy = new ListNode(-1);
        ListNode* curr = dummy;
        while(!pq.empty()){
            ListNode* minNode = pq.top();
            pq.pop();
            curr -> next = minNode;
            curr = curr -> next;
            if(minNode -> next != nullptr){
                pq.emplace(minNode -> next);
            }
        }
        return dummy -> next;
    }
};