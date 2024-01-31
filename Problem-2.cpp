// Time Complexity : O(Nlog k) where N = nk

// Space Complexity : O(k)

// Did this code successfully run on Leetcode : Yes

// Appoarch: Created a min heap (priority queue), iterated through the list, stored the heads
// of all the lists in PQ. Popped the min and stored in new list and returned it.

// 23. Merge k Sorted Lists

#include<bits/stdc++.h>
using namespace std;
 
 // Definition for singly-linked list.
  struct ListNode {
      int val;
      ListNode *next;
      ListNode() : val(0), next(nullptr) {}
      ListNode(int x) : val(x), next(nullptr) {}
      ListNode(int x, ListNode *next) : val(x), next(next) {}
  };
 
class cmp {
public:
    // Comparator function
     bool operator()(const ListNode* a, const ListNode* b){
        return a->val > b->val;
    }
};

class Solution {
public:
   
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<ListNode*, vector<ListNode*>, cmp> pq;
        for(auto head : lists){
            if(head!=NULL){
                pq.push(head);
            }
        }
        ListNode* dummy = new ListNode(-1);
        ListNode* curr = dummy;
        while(!pq.empty()){
            ListNode* min = pq.top();
            pq.pop();
            curr->next = min;
            curr = curr->next;
            if(min->next != NULL){
                pq.push(min->next);
            }
        }
        return dummy->next;
    }
};