// Time Complexity: O(klogn)
// Space Complexity: O(k*n)

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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        
        if(lists.size() == 0) return nullptr;

        auto cmp = [](ListNode* a, ListNode* b) { return a->val > b->val; }; 
         priority_queue<ListNode*, vector<ListNode*>, decltype(cmp)> pq(cmp);

         for(int i = 0; i < lists.size(); i++) {
             ListNode* l = lists[i];
              
             while(l != nullptr) {
                 ListNode* ptr = l->next; 
                 l->next = nullptr; 
                 pq.push(l);
                 l = ptr; 
             }
         }

         if(pq.empty()) return nullptr; 

        ListNode* head = pq.top(); 
        pq.pop(); 
        ListNode* ptr = head; 
        while(!pq.empty()) {
            ListNode* nextNode = pq.top();
            pq.pop();  
            ptr->next = nextNode; 
            ptr = ptr->next; 
         }

         return head;     
    }
};