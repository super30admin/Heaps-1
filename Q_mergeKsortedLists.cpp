// ## Problem2

// Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)


//  Approach: Min Heap 
//The idea is to use heap data structure , could be done with min heap - store the k heads of all lists and then pop an element from the priority queue
// based on popped element, form result and increment the curr popped element if its next is not NULL.

// # Time complexity: O(nklogk )
// # Space complexity: O(k) as k elements in heap



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
    
    struct compare
    {
        bool operator()(const ListNode* l1, const ListNode* l2)
        {
            return l1->val > l2->val;
        }
    };
    
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        
        if(lists.size()==0){
            return NULL;
        }
     
       ListNode* dummy = new ListNode(INT_MIN);
       ListNode* result = dummy;
        
       priority_queue< ListNode*, vector<ListNode*>, compare > pq;
        
       for(int i=0; i< lists.size() ; i++){  //O(klogk)
           
           ListNode* head = lists[i];
           if(head!= NULL){
               pq.push(head);
           }
       }
        
       while(!pq.empty()){  //(Onklogk)
           ListNode* curr = pq.top();
           pq.pop();
           dummy->next = curr;
           if(curr->next != NULL){
              pq.push(curr->next);
           }
           dummy= dummy->next;
       } 
       return result->next; 
    }
};