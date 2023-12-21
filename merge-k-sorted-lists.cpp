/*Use a min-heap (priority queue) to track the smallest element among the heads of all lists.
Populate the min-heap initially with the heads of all non-empty lists.
Repeatedly extract the smallest node from the min-heap, add it to the merged list, and push its next node to the min-heap if it exists.
Time Complexity: O(N log K), where N is the total number of nodes in all lists, and K is the number of lists. Each push and pop operation in the priority queue takes log K time.

Space Complexity: O(K), where K is the number of lists. The priority queue stores at most K nodes at any given time. Additionally, O(1) space is used for the merged list.*/
#include<bits/stdc++.h>
using namespace std;
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
        auto compare=[](ListNode* a, ListNode* b){return a->val>b->val;};
        priority_queue<ListNode*, vector<ListNode*>,decltype(compare)>minHeap(compare);
        ListNode* head=new ListNode(0);
        ListNode* point=head;
        for(ListNode* l:lists){
            if(l){
                minHeap.push(l);
            }
        }
        while(!minHeap.empty()){
            ListNode* node=minHeap.top();
            minHeap.pop();
            point->next=new ListNode(node->val);
            point=point->next;
            if(node->next){
                minHeap.push(node->next);
            }
        }
        ListNode* result=head->next;
        delete head;
        return result;
    }
};