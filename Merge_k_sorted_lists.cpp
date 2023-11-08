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
    struct compare{
        bool operator()(ListNode*l1, ListNode*l2){
            return l1->val > l2->val;
        }
    };
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        //by default cpp takes max heap, so we have to make a min heap but this time we have to compare the values inside the nodes and we cannot comapare the nodes, so we make a compare comparator of our own.
        priority_queue<ListNode*, vector<ListNode*>, compare> pq;
        for(ListNode* head: lists){
            if(head!=NULL){
                pq.push(head);
            }
        }
        ListNode *dummy = new ListNode(-1);
        ListNode* curr = dummy;
        while(!pq.empty()){
            ListNode* min = pq.top();
            pq.pop();
            curr->next = min;
            curr = curr->next;
            if(min->next!=NULL){
                pq.push(min->next);
            }
        }
        ListNode* result = dummy->next;
        delete dummy;
        return result;
    }
};
