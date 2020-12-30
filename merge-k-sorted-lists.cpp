//Time - O(Nlogk) k - number of linked lists & N is the total number of nodes
//Space - O(k)

class Solution {
public:
    
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        
        if(lists.size()==0) return NULL;
        auto compare = [](ListNode* a, ListNode* b){
            if(a==NULL) return true;
            else if(b == NULL) return false;
            return a->val>b->val;
        };
        priority_queue<ListNode*, vector<ListNode*>, decltype(compare)> q(compare);
        for(int i=0;i<lists.size();i++){
            q.push(lists[i]);
        }
        ListNode* curr = new ListNode(0), *head = curr;
        
        while(!q.empty() && curr){
            curr->next = q.top();q.pop(); 
            curr = curr->next;
            if(curr && curr->next){
                q.push(curr->next);
            }
        }
        
        return head->next;
        
    }
};