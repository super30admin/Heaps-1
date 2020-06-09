// Time Complexity : O(nk)logk; n= average number of nodes in list; k=number of lists to merge
// Space Complexity : O(k) - priority queue only contains k nodes at a time 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Create a min-heap and add the k heads in the heap
// 2. Pop the first head, point a dummy node to it, add next of popped node to queue, and advance dummy to added node
// 3. Keep popping out of till queue is not empty

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class comparator{
  public:
    int operator () (ListNode* a, ListNode* b){
        return a->val > b->val;
    }
};
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode* head = new ListNode();
        ListNode* curr = head;
        if(lists.size()==0)
            return nullptr;
        priority_queue<ListNode*, vector<ListNode*>, comparator> pq;
        for(auto node: lists)
            if(node)
                pq.push(node);
        while(!pq.empty()){
            auto node = pq.top(); pq.pop();
            curr->next = node;
            if(node->next) pq.push(node->next);
            curr = node;
        }
        return head->next;
    }
};