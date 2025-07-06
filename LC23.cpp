// Time complexity O(kn)
// Space complexity O(k)

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
    struct Comparator
    {
        bool operator()(const ListNode* lhs, const ListNode* rhs) {
            return lhs->val > rhs->val;
        }
    };

    ListNode* mergeKLists(vector<ListNode*>& lists) {
        
        priority_queue<ListNode*, vector<ListNode*>, Comparator> que;
        
        for (auto list : lists) 
        {
            if (list != nullptr) 
            {
                que.push(list);
            }
        }

        ListNode* head = new ListNode(-1);
        ListNode* curr = head;
        
        while (!que.empty()) 
        {
            ListNode* node = que.top();
            que.pop();

            curr->next = node;
            curr = curr->next;

            if (node->next != nullptr) 
            {
                que.push(node->next);
            }
        }

        return head->next;
    }
};