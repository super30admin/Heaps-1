// Time Complexity :O(NK log K)
// Space Complexity : O(K) size of min-heap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Merge K-sorted lists

#include<vector>
#include<queue>
#include<iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};


class compares {
public:
    bool operator()( ListNode* l,  ListNode* r) {
        return l->val > r->val;
    }
};

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        
        // put head of each list in the priority queue, extract the minimum and then put its next in the queue
        
        priority_queue<ListNode*, vector<ListNode*>, compares> pq;
        
        for(auto head : lists){ // pushed only heads of respective lists
            if(head)
                pq.push(head);
        }
        
        ListNode *dummy = new ListNode(-1);
        ListNode *curr = dummy;
        
        while(!pq.empty()){
            ListNode *min = pq.top();
            pq.pop();
            curr->next = min;
            curr = curr->next;
            if(min->next)
                pq.push(min->next);
            
        }
        
        return dummy->next;
    }
};