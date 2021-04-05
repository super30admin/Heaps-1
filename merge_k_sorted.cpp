//TC: O(Nlog(k)). Insertion will take log(k) operations since our priority queue is just of length k.
//N here is the total number of nodes

//SC: O(n) since we create a new linked list.


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
    
    
    struct comparator{
        bool operator()(struct ListNode* l1, struct ListNode* l2)
        {
            return l1->val > l2->val;
        }
    };
    
    
    
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        
        //can use a min heap here. We add the first elements in all the linked lists to a min heap and then pop them out in ascending order. As we pop them out, we replace that element by the next one in that list.
        
        if(lists.size() == 0)
            return NULL;
        
        
        priority_queue<ListNode*, vector<ListNode*>, comparator> minHeap; 
        
        
        for(auto firstelement: lists){
            if(firstelement!=NULL){
                minHeap.push(firstelement);
            }
        }
        
        //dummy listnode to keep the result.
        ListNode result(0);
        ListNode *curr = &result;
        
        
        while(minHeap.size()>0){
            
            ListNode *top = minHeap.top();
            minHeap.pop();
            
            curr->next = top;
            curr = curr->next;
            
            if(top->next!=NULL)
                minHeap.push(top->next);
            
        }
        
        //not a pointer so, use the '.' operator
        return result.next;
        
        
        
    }
};