//TC-O(NLOGk)
//sc-O(K)
class Solution {
public:
    class cmp{
        public:
    bool operator()(ListNode* x,ListNode* y){
        return (x->val>y->val);
    }
    };
    ListNode* mergeKLists(vector<ListNode*>& lists) {
//         if(!lists.size())return NULL;
//         for(int i=1;i<lists.size();i++){
//             lists[0]=merge(lists[0],lists[i]);
//         }
//         return lists[0];
//     }
//     ListNode* merge(ListNode *l1,ListNode*l2){
//         ListNode* main=new ListNode(0);
//         ListNode*head=main;
//         while(l1 &&l2){
//             if(l1->val<l2->val){
//                 head->next=l1;
//                 l1=l1->next;
//             }
//             else{
//                 head->next=l2;
//                 l2=l2->next;
//             }
//             head=head->next;
//         }
//         if(l1){head->next=l1;}
//         if(l2){head->next=l2;}
        
//         return main->next;
        priority_queue<ListNode*,vector<ListNode*>,cmp>q;
        for(int i=0;i<lists.size();i++){
            if(lists[i])
            q.push(lists[i]);
        }
        ListNode* main=new ListNode(0);
        ListNode* curr=main;
        while(!q.empty()){
            auto temp=q.top();
            curr->next=q.top();
            q.pop();
            curr=curr->next;
                if(temp->next){
                    q.push(temp->next);
                }
            
        }
        return main->next;
    }
};