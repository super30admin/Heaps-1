// TC = O(n log k)
// SC = O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
// class Solution {
// public:
//     // TC = O(nk), SC = O(n)
//     ListNode* mergeKLists(vector<ListNode*>& lists) {
//         ListNode* result = new ListNode(INT_MIN);
//         for(ListNode* li : lists) {
//             result = merge2Lists(li, result);
//         }
//         return result->next;
//     }
//     ListNode* merge2Lists(ListNode *h1, ListNode *h2) {
//         ListNode *result = new ListNode(INT_MIN);
//         ListNode *curr = result;
//         while(h1 != NULL && h2 != NULL) {
//             if(h1->val < h2->val) {
//                 curr->next = h1;
//                 h1 = h1->next;
//             }
//             else {
//                 curr->next = h2;
//                 h2 = h2->next;
//             }
//             curr = curr->next;
//         }
//         if(h1 != NULL) curr->next = h1;
//         if(h2 != NULL) curr->next = h2;
//         return result->next;
//     }
// };

class Solution {
public:
// TC = O(n log k), SC = O(n)
struct CompareListNode {
    bool operator()(const ListNode* a, ListNode* b) {
        return a->val > b->val;
    }
};
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<ListNode*, vector<ListNode*>, CompareListNode> pq;
        for(ListNode* head : lists) {
            if(head != NULL) pq.push(head);
        }
        ListNode* result = new ListNode(-1);
        ListNode* curr = result;
        while(!pq.empty()) {
            ListNode* min = pq.top();
            pq.pop();
            curr->next = min;
            curr = curr->next;
            if(min->next != NULL) pq.push(min->next);
        }
        return result->next;
    }
};