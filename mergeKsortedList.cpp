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
        ListNode * result;
          priority_queue<ListNode*> pq;

          for(ListNode* head:lists)
          {
              if(head != NULL)
              {
                  pq.push(head);
              }
          }

          while(pq.empty())
          {
              ListNode * temp = pq.top();
              pq.pop();
              if(temp->next != NULL)
              {
                  pq.push(temp->next);
              }
              result->next = temp;
              result = result->next;
          }

        return result;
    }
};