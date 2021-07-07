
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
//Time : O(nlogk)
//SPace : O(n)
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<int> q;
        for(auto &list:lists){
            while(list!=NULL){
                q.push(list->val);
                list=list->next;
            }
        }
        
        if(q.empty())
            return NULL;
        ListNode* head=NULL;
        ListNode* temp; 
        
        while(!q.empty()){
            if(head==NULL){
                head=new ListNode(q.top());    
                q.pop();
            }
            else{
                temp=new ListNode(q.top());
                q.pop(); 
                temp->next=head;
                head=temp;
            }                       
        }
        return head;
    }
};
