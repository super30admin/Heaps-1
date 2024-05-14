//Time O( n log k ) : n will be total nodes in final linked list, k will be number of lists that we will merge.
// space: O(n)
//Leetcode: yes
//issue seen: none

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

        priority_queue<int, vector<int>, greater<int>>pq;

        for(int i=0; i < lists.size(); i++){
            ListNode* node = lists[i];
            while(node){
                pq.push(node->val);
                node = node->next;
            }
        }
        ListNode* dummy = new ListNode();
        ListNode* head = dummy;
        while(pq.size()){
            ListNode* node = new ListNode(pq.top());
            pq.pop();
            head->next = node;
            head = head->next;
        }
        return dummy->next;
    }
};
