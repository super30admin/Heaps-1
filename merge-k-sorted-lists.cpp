// Time Complexity : O(nklogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>
#include <queue>
  
using namespace std; 
 
class Solution {
private:
    struct ListNode {
        int val;
        ListNode *next;
        ListNode(int x, ListNode *next) : val(x), next(next) {}
        ListNode() : val(0), next(nullptr) {}
        ListNode(int x) : val(x), next(nullptr) {}
    };
public:
    // using priority queue add head of all the ListNode to minheap and compare the min and keep adding to the list until min heap becomes empty
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        auto cmp = [](const ListNode* a, const ListNode* b) {
        return a->val > b->val;
        };
        priority_queue<ListNode*, vector<ListNode*>, decltype(cmp)> pq(cmp);
        for (auto it : lists) {
            if (it != nullptr) {
                pq.push(it);
            }
        }
        ListNode* dummy = new ListNode(-1);
        ListNode* curr = dummy;
        while (!pq.empty()) {
            ListNode* minNode = pq.top();
            pq.pop();
            curr->next = minNode;
            curr = curr->next;
            if (minNode->next != nullptr) {
                pq.push(minNode->next);
            }
        }
        return dummy->next;
    }
};