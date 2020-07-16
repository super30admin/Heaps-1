//min heap
// Time Complexity : O(nklog(nk)) // n number of list, k avg size of each list
// Space Complexity : O(n) // Creating a queue for storing one element from each queue
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//1. Create a priority_queue and store head of each valid queue
//2. Heapify to find min element via min heap and to the dummy node.
//3. Traverse through the given linked lists and add next non-null element

class Comparator{
  public:
    bool operator()(const ListNode* a, const ListNode* b){
       return a->val > b->val; 
    } 
};
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        //edge case
        if(lists.size()==0) return NULL;
        
        //logic 
        //Dummy node creation
        ListNode* dummy = new  ListNode();
        ListNode* result = dummy;
        //priority_list creation
        priority_queue <ListNode*, vector<ListNode*>, Comparator> pq;
        //Add head of all the valid lists
        for(int i=0; i<lists.size();i++){
             if(lists[i] !=NULL) pq.push(lists[i]);
        }
        while(!pq.empty()){
            ListNode* curr = pq.top();
            pq.pop();
            dummy->next = curr;
            dummy = curr;
            if(curr->next !=NULL) pq.push(curr->next);
        }
        return result->next;
    }
};
