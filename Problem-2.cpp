/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 Time Complexity = O(NK*LogK)
 Space Complexity = O(k)
 where k is the number of lists and we are only inserting one element from each list at a time(after removal of one node from queue we add its next to the queue ) then the Space complexity is O(k). 
 And also we are traversing NK i.e- N is the average elements in one list, and insertion of node in heap takes logK time. This is how we get Time Complexity od O(NK*Logk).
 */
class Solution {
public:
    struct Comp {
    bool operator() (const ListNode * a, const ListNode * b) {
        return a->val > b->val;
    }
};
    
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.size()==0)
            return NULL;
        int i;
        priority_queue<ListNode*, vector<ListNode*>, Comp> pq;
        for(ListNode* list : lists)
            if(list!=NULL)
                pq.push(list);
        ListNode* dummy = new ListNode(-1);
        ListNode* curr = dummy;
        while(!pq.empty()){
            ListNode* minelement = pq.top();
            curr->next = minelement;
            minelement = minelement->next;
            pq.pop();
            if(minelement!=NULL)
                pq.push(minelement);
            curr = curr->next;
        }
        return dummy->next;
    }
};
