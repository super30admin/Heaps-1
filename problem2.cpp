//TC - O(n*k*logk)
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode* head1=NULL;
        if(lists.size()==0)
            return head1;
        priority_queue<pair<int,ListNode*>,vector<pair<int,ListNode*>>, greater<pair<int,ListNode*>>>q;
        for(int i=0;i<lists.size();i++){
            if(lists[i]!=NULL)
            q.push({lists[i]->val,lists[i]});
        }
        if(q.empty()){
            return head1;
        }
        ListNode* temp = new ListNode();
        ListNode* head = temp;
        temp->val=q.top().first;
        if(q.top().second->next)
            q.push({q.top().second->next->val,q.top().second->next});
        q.pop();
        temp->next=NULL;
        while(!q.empty()){
            ListNode* temp1 = new ListNode();
        temp1->val=q.top().first;
        if(q.top().second->next)
            q.push({q.top().second->next->val,q.top().second->next});
        q.pop();
        temp1->next=NULL;
        temp->next=temp1;
        temp=temp->next;
        }
        return head;
    }
};