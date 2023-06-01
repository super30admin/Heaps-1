// Time Complexity : O(nklogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// we use a min heap of size k , we insert all heads into it. while the heap was not empty, we proceed to pick the min node and attach
// to our dummy head.we keep on adding next node of picked node from min heap . 

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
class Solution {
public:
    class comparator{
        public:
        bool operator()(const ListNode* p,const ListNode* q)
        {
            return p->val > q->val;
        }
    };
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<ListNode*, vector<ListNode*>,comparator>pq;
        ListNode* dummy = new ListNode();
        for(ListNode* h: lists)
        {
            if(h!=NULL) pq.push(h);
        }
        ListNode* curr = dummy;
        while(!pq.empty())
        {
            ListNode* t = pq.top();pq.pop();
            curr->next = t;
            if(t->next!=NULL) pq.push(t->next);
            curr = curr->next;
        }
        return dummy->next;
    }
};