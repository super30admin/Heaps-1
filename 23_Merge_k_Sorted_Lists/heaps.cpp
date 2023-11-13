#include<bits/stdc++.h>
using namespace std;

/*
Approach: Heaps: Maintain a min heap. Initially push all the heads into this heap. Now the smallest head will be the next element in sorted list. Push the next element of this current element into the heap (if it is not null). Continue till heap is empty.
Time: O(Nlogk) .. N = total elements from all lists, k=number of lists
Working on leetcode: Yes
*/

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class CustomComparator {
    public:
    bool operator()(ListNode* e1, ListNode* e2) {
        return e1->val > e2->val;
    }
};

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<ListNode*, vector<ListNode*>, CustomComparator> minHeap;
        for(ListNode* head: lists) {
            if(head!=nullptr)
                minHeap.push(head);
        }

        ListNode* head = new ListNode(-1);
        ListNode* prev = head;
        ListNode* next = nullptr;

        while (!minHeap.empty()) {
            next = minHeap.top();
            minHeap.pop();
            if(next->next != nullptr) {
                minHeap.push(next->next);
            }
            prev->next = next;
            prev = prev->next;
        }

        return head->next;
        
    }
};