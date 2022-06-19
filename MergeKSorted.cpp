Using Heap

Time = O(Nlogk) where N = total elements across 3 lists
space = O(k)

class comparator{
    public:
    bool operator()(ListNode *x,ListNode *y){
        return (x->val>y->val);
    }
};

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<ListNode*, vector<ListNode*>,comparator> pq;
        for(ListNode *head: lists){
            if(head!=NULL){
                pq.push(head);
            }
        }
        ListNode *dummy = new ListNode(-1);
        ListNode *curr = dummy;
        while(!pq.empty()){
            ListNode *min = pq.top(); pq.pop();
            curr->next = min;
            curr = curr->next;
            if(min->next!=NULL){
                pq.push(min->next);
            }
        }
        return dummy->next;
    }
};

SOLUTION 2 - MERGING 2 lists at a time 

O(k * nk) time where nk = N
space = O(1)
    
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        int size = lists.size();
        if(size==0) return NULL;
        for(int i=0;i<lists.size()-1;i++){
            lists[i+1] = mergeTwoLists(lists[i],lists[i+1]);
        }
        return lists[size-1];
    }
    
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode *p1 = list1;
        ListNode *p2 = list2;
        ListNode *dummy = new ListNode(-1);
        ListNode *curr = dummy;
        while(p1 && p2){
            if(p1->val<=p2->val){
                curr->next = p1;
                p1 = p1->next;
            }
            else{
                curr->next = p2;
                p2 = p2->next;
            }
            curr = curr->next;
        }
        if(p1){
            curr->next = p1;
        }
        if(p2){
            curr->next = p2;
        }
        return dummy->next;
    }
};
