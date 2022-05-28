// Time Complexity : O(nk*log(k))
// Space Complexity : O(k)
//    where n : average number of elements in given input lists.
//          k : number of lists.
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Build min heap of size k. Initialize the priority queue with the root elements of each list.
 * Repeat the following operation until queue is not empty. 
 *    1. Pop element from queue. Add popped element to result list. 
 *    2. Insert the next element pointed by popped element in the priority queue. 
 */

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
        
        ListNode* root = nullptr;
        ListNode* cur = nullptr;
        
        auto cmp =  [](const ListNode* l1, const ListNode* l2){
            return l1->val > l2->val;} ;
        priority_queue<ListNode*, vector<ListNode*>, decltype(cmp)> pq(cmp);
        
        for (auto list : lists)
        {
            if(list != nullptr)
                pq.push(list);
        }
        
        while(!pq.empty())
        {
            ListNode* node = pq.top();
            pq.pop();
            
            if (root == nullptr)
            {
                root = cur = node;
            }
            else
            {
                cur->next = node;
            }
            cur = node;
            
            if (node->next != nullptr)
                pq.push(node->next);
        }
        return root;
    }
};