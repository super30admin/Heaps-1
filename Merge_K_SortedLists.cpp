// Time Complexity : O(nklog(nk)) // n number of list, k avg size of each list
// Space Complexity : O(no of lists) for the heap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


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


// addtiing the custom comparator to compare the list nodes
class Comparator{
  public:
    bool operator()(const ListNode* a, const ListNode* b){
       return a->val > b->val; 
    } 
};


class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        
        // define our priotrity queue using our comparator
         priority_queue <ListNode*, vector<ListNode*>, Comparator>  myheap;
        
        
        // add all the heads of lists to the heap
        for(ListNode* list:lists){
            
            if(list != NULL){
                myheap.push(list);
            }
        }
        
        // getting dummy referenbce before the head for the result.
        ListNode* dummyHead = new ListNode(-1);
        
        ListNode* head = dummyHead;
        
        
        while(!myheap.empty()){
            
            ListNode* top = myheap.top();
            myheap.pop();
            
            
            
            if(top->next != NULL){
                myheap.push(top->next);
            }
            
            head->next = top;
            head = head->next;
            
           
        }
         return dummyHead->next;
    }
};