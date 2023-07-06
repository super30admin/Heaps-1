/*
Time complexity: O(nklog(k))
Space complexity: O(k)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue <pair< int , ListNode* >, vector<pair< int , ListNode*>>, greater<pair< int , ListNode* >>> pq;
        for(auto i : lists) {
            if(i != NULL) {
                pq.push({i->val, i});
            }
        }
        ListNode * head = NULL;
        ListNode * x = head;
        while(!pq.empty()) {
            
            ListNode * y = pq.top().second;
            pq.pop();

            if(head == NULL) {
                x = new ListNode(y->val);
                head = x;
            }else {
                x ->next = new ListNode(y->val);
                x = x->next;
            }
            if(y -> next != NULL) {
                pq.push({y->next->val, y->next});
            }
        }
        return head;
    }
};