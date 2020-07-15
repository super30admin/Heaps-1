//Time Complexity-O(nklogk)
//Space Complexity-O(k)
//Runs successfully on leetcode
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
    struct comparelist
    {
        bool operator()(const ListNode* l1,const ListNode* l2)
        {
            return l1->val>l2->val;
        }
    };
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.empty())
            return {};
        priority_queue<ListNode*,vector<ListNode*>,comparelist>pq;
        ListNode*dummy=new ListNode();
        ListNode*result=dummy;
        for(ListNode* head:lists)
            if(head!=NULL)
                pq.push(head);
        while(!pq.empty())
        {
            ListNode* min=pq.top();
            pq.pop();
            dummy->next=min;
            dummy=dummy->next;
            if(min->next!=NULL)
                pq.push(min->next);
        }
        return result->next;
    }
};