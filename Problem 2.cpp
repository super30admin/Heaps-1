//Time Complexity : O(nklogk)
// Space Complexity :O(1)
class compare {
public:
    bool operator() (ListNode* a, ListNode* b) {
        return a->val >b->val;
    }
};
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        //min heap solution
        // min heap priority_queue<int,vector<int>,greater<int>> pq;
        priority_queue<ListNode*,vector<ListNode*>,compare> pq;
        
        ListNode* head = new ListNode(-1);
        ListNode* res = head;
        
        for(int i=0; i<lists.size(); i++){
            if(lists[i]!=NULL)
                pq.push(lists[i]);
        }
        
        while(pq.empty()==false){
            ListNode* min_node = pq.top();
            head->next = min_node;
            head = head->next;
            pq.pop();
            if(min_node->next!=NULL){
                min_node = min_node->next;
                pq.push(min_node);
            }
        }
        
        return res->next;
        
    }
};