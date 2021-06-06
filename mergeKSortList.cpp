// Time Complexity :O(nlogk) k is the number of linked lists
// Space Complexity : O(k) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
class compares {
public:
    bool operator()( ListNode* l,  ListNode* r) {
        return l->val > r->val;
    }
};
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<ListNode*,vector<ListNode*>,compares> pq;
        for(auto head : lists){
            if(head)
                pq.push(head);
        }
        ListNode *dummy = new ListNode(-1);
        ListNode *curr = dummy;
        while(!pq.empty()){
            ListNode *min = pq.top();
            pq.pop();
            curr->next = min;
            curr=curr->next;
            if(min->next)
                pq.push(min->next);
        }
        return dummy->next;
    }
};