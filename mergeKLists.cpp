// Time Complexity : O(nLog(k))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
#include <iostream>
#include <priority_queue>

using namespace std;

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
        priority_queue<pair<int, ListNode*>, vector<pair<int, ListNode*>>, greater<pair<int, ListNode*>>> pq;

        for (auto& l:lists) {
            if(l!=nullptr) pq.push({l->val,l});
        }

        ListNode* result = new ListNode(0);
        ListNode* temp = result;
        while (!pq.empty()) {
            auto p = pq.top();
            temp->next = p.second;
            pq.pop();
            if(p.second->next!=nullptr) pq.push({p.second->next->val, p.second->next});
            temp = temp->next;
        }
        return result->next;
    }
};