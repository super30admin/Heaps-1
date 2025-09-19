#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
class ListNode{
public:    
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
/*
We put the first node of every list into a min-heap.
Each time we pull out the smallest node and add its next to the heap.
That way, we're always getting the next smallest node to our merged list.
*/
class Compare{
public:    
    bool operator()(ListNode* a, ListNode* b){
        return a->val > b->val;
    }
};
class Solution{
public:
    ListNode* mergeKLists(vector<ListNode*>& lists){
        priority_queue<ListNode*, vector<ListNode*>, Compare> pq;
        for(ListNode* list : lists){
            if(list != nullptr) pq.push(list);
        }

        ListNode* dummy = new ListNode(-1);
        ListNode* curr = dummy;
        while(!pq.empty()){
            ListNode* min = pq.top(); pq.pop();
            curr->next = min;
            curr = curr->next;
            if(min->next != nullptr) pq.push(min->next);
        }
        return dummy->next;
    }
};
