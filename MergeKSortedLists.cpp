// Time Complexity : O(NKlogK) where N=Number of elements in array.
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//This problem is solved using min heap.

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {

        if(lists.size()==0)
            return NULL;

        auto cmp = [](const ListNode* lhs, const ListNode* rhs)
        {
            return lhs->val > rhs->val;
        };
        priority_queue<ListNode*, vector<ListNode*>, decltype(cmp)> q(cmp);

        for(auto head: lists){
            if(head!=NULL)
                q.push(head);
        }
        ListNode* dummy = new ListNode(0);
        ListNode* res = dummy;

        while(!q.empty()){
            ListNode* temp = q.top();
            q.pop();
            dummy->next = temp;
            dummy = dummy->next;
            if(temp->next!=NULL){
                q.push(temp->next);
            }
        }
        return res->next;
    }
};
