/* 
    Time Complexity                              :  O(N log k)
    Space Complexity                             :  O(k) - maximum number of ListNodes stored in the 
                                                    priority queue.
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/merge-k-sorted-lists/

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
private:
    ListNode *ans;
    
public:
    
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        
        auto cmp = [](ListNode *a, ListNode *b) { return a->val > b->val; };
        priority_queue<ListNode*, vector<ListNode*>, decltype(cmp)> pq(cmp);
        
        int k = lists.size();
        
        ListNode *dummy = new ListNode(-1);
        ListNode *curr = dummy;
        
        for(auto list : lists) {
            if(list == NULL) continue;
            pq.push(list);
        }
        
        while(!pq.empty()) {
            ListNode *node = pq.top();
            pq.pop();
            curr->next = node;
            curr = curr->next;
            node = node->next;
            if(node) {
                pq.push(node);
            }
        }
        
        
        return dummy->next;
        
    }
};