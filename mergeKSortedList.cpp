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
        priority_queue<int, vector<int>, greater<int>> pq;
        for(auto x:lists){
            ListNode *head=x;
            while(head!=NULL) {
                pq.push(head->val);
                head=head->next;
            }
        }
        ListNode *start=NULL;
        ListNode *temp=start;
        while(!pq.empty()) {
            if (start == NULL) {
                start=new ListNode(pq.top());
                pq.pop();
                temp=start;
            } else {
                temp->next=new ListNode(pq.top());
                pq.pop();
                temp=temp->next;
            }
        }
        return start;
    }
};