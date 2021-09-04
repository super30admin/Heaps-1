// Time Complexity : O(N*K*K)where N is average length of elements in list and K is the number of lists.
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
public:
    struct comp{
        bool operator() (const ListNode* a, const ListNode* b){
            return a->val > b->val;
        }
    };
    
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.empty() || lists.size() == 0)
            return NULL;
        
        ListNode* merged = new ListNode(INT_MIN);
        for(ListNode* list : lists){
            merged = merger(merged, list);
        }
        return merged->next;
    }
    
    ListNode* merger(ListNode* l1, ListNode* l2){
        ListNode* dummy = new ListNode(-1);
        ListNode* curr = dummy;
        while(l1 != NULL && l2 != NULL){
            if(l1->val < l2->val){
                curr->next = l1;
                l1 = l1->next;
            }
            else{
                curr->next = l2;
                l2 = l2->next;
            }
            curr = curr->next;
        }
        if(l1 != NULL)
            curr->next = l1;
        if(l2 != NULL)
            curr->next = l2;
        return dummy->next;
    }
};


// Time Complexity : O(N*K*logK)where N is average length of elements in list and K is the number of lists.
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    struct comp{
        bool operator() (const ListNode* a, const ListNode* b){
            return a->val > b->val;
        }
    };
    
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.empty() || lists.size() == 0)
            return NULL;
        priority_queue<ListNode*, vector<ListNode*>, comp> pq;
        for(ListNode* head : lists){
            if(head != NULL)
                pq.push(head);
        }
        ListNode* dummy = new ListNode(-1);
        ListNode* curr = dummy;
        while(!pq.empty()){
            ListNode* minElement = pq.top();
            pq.pop();
            curr->next = minElement;
            minElement = minElement->next;
            if(minElement != NULL)
                pq.push(minElement);
            curr = curr->next;
        }
        return dummy->next;
    }
};
