#include<iostream>
#include<vector>
#include<queue>
using namespace std;
struct ListNode {
      int val;
      ListNode *next;
      ListNode() : val(0), next(nullptr) {}
      ListNode(int x) : val(x), next(nullptr) {}
      ListNode(int x, ListNode *next) : val(x), next(next) {}
  };
class Solution {
public:
    struct compare {
        bool operator()(ListNode* a, ListNode* b) {
            return a->val > b->val; 
        }
    };

    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<ListNode*, vector<ListNode*>, compare> pq;
        for (auto& node : lists) {
            if (node != nullptr) {
                pq.push(node);
            }
        }
        ListNode* dummy = new ListNode(-1);
        ListNode* curr = dummy;
        while (!pq.empty()) {
            ListNode* top = pq.top();
            pq.pop();
            curr->next = top;
            curr = curr->next;
            if (top->next != nullptr) {
                pq.push(top->next);
            }
        }

        return dummy->next;
    }
};

