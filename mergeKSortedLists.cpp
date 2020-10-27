//time complexity:O(nlogk)
//space complexity:O(n)
//executed on leetcode: yes
//approach:using priority queueu (min heap)
//any issues faced? no

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
        for(ListNode* head: lists)
        {
            while(head)
            {
                pq.push(head->val);
                head=head->next;
            }
        }
        ListNode* dummy=new ListNode(0);
        ListNode* head=dummy;
        while(!pq.empty())
        {
            head->next=new ListNode(pq.top());
            pq.pop();
            head=head->next;
        }
        return dummy->next;
    }
};