// time: O(nlogk)
// space: O(k)
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
    struct CompareListNode {
        bool operator()(ListNode* l1, ListNode* l2) {
            return l1->val > l2->val; // Min-heap based on ListNode value
        }
    };

    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<ListNode*, vector<ListNode*>, CompareListNode> pq;
        for(ListNode* head : lists) {
            if(head != NULL) {
                pq.push(head);
            }
        }
        ListNode* result = new ListNode();
        ListNode* curr = result; 
        while(!pq.empty()) {
            ListNode* temp = pq.top();
            pq.pop();
            curr -> next = temp;
            curr = curr -> next;
            if(temp -> next != NULL) {
                pq.push(temp -> next);
            }
        }
        return result -> next;
    }
};