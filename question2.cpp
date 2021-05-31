/*
Time complexity - O(nklogk), n is the average length of the list, k is the number of lists
Space complexity - O(k)
*/
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
        if (lists.size() == 0) return NULL;
        ListNode* dummy = new ListNode(-1);
        int k = lists.size();
        priority_queue<ListNode*, vector<ListNode*>, compare> pq;
        for (auto list:lists){
            if (list) pq.push(list);
        }
        ListNode* temp = dummy;
        while (pq.size() != 0){
            temp->next = pq.top(); pq.pop();
            if (temp->next->next) pq.push(temp->next->next);
            temp = temp->next;
        }
        return dummy->next;
    }
    
private:
    struct compare{
        bool operator()(const ListNode* a, const ListNode*b){
            return a->val > b->val;
        }
    };
};