
//TIMEO(N log N)
//SPACE(O(n))


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
    
    struct CompareNodes {
    bool operator()(const ListNode* a, const ListNode* b) {
        return a->val > b->val; // Min heap, smallest value has highest priority
    }
    };
    priority_queue<ListNode* , vector<ListNode*>, CompareNodes> pq;
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        for(ListNode* head:lists){
            if(head != nullptr)
            {
                pq.push(head);

            }
        }
        ListNode* dummy = new ListNode(-1);
        ListNode* curr = dummy;
        while(!pq.empty()){
            ListNode* currmin =pq.top();
            pq.pop();
            
            curr->next = currmin;
            curr = curr->next;

            

            if(currmin->next != nullptr){
                pq.push(currmin->next);
            }





        }

        return dummy->next;
        
        
    }
};