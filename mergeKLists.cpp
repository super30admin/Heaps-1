/*
Intuition: 

Solution 1) Merge 2 lists at a time. Perform this for all the lists.
Solution 2) Use a heap of size k to always get a min value 
#####################################################################
Solution 1:
Time Complexity : O(nk^2) 
Space Complexity : O(1)
#####################################################################
Solution 2:
Time Complexity : O(N), N = total number of elements in all the lists
Space Complexity : O(k)
#####################################################################
*/

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode* dummy = new ListNode();
        dummy->val = INT_MIN;
        ListNode* merged = dummy;
        for ( auto list: lists){
            merged = merge2Lists(merged, list );
        }
        return merged->next;
    }
    
    ListNode* merge2Lists(ListNode* l1, ListNode* l2) {
        ListNode* dummy = new ListNode();
        dummy->val = INT_MIN;
        ListNode* curr = dummy;
        
        while( l1 != NULL and l2 != NULL){
            
            if ( l1->val <= l2->val){
            
                curr->next = l1;
                l1 = l1->next;
                
            }
            else{
                curr->next = l2;
                l2 = l2->next;
            }
            curr = curr->next;
        }
        if ( l1 == NULL){
            curr->next = l2;
        }
        if ( l2 == NULL){
            curr->next = l1;
        }
        return dummy->next;
        
        
    }
    
};


//Using priority queue
struct compareValues {
    bool operator()(ListNode* p1, ListNode*  p2) {
        //Min heap
        return p1->val > p2->val;
    }
};
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode* dummy = new ListNode();
        dummy->val = INT_MIN;
        ListNode* curr = dummy;
        priority_queue<ListNode*, vector<ListNode*>, compareValues> pq;
 
        for ( auto list: lists ){
            if ( list != NULL){
                cout << list->val<<endl;
                pq.push(list);
            }
        }
        
        while (pq.size()!=0){
            
            ListNode* node = pq.top();
            pq.pop();
            
            curr->next = node;
            node = node->next;
            if ( node!= NULL){
                pq.push(node);
            }
            curr = curr->next;

        }
        return dummy->next;
    }
};