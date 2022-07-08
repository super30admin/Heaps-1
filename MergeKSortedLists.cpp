// Time Complexity -> O(n*logk).
// Space Complexity -> O(k)
// Problems faced - NO!
// It runs on Leetcode!
class Solution {
    struct node_cmp{
    bool operator()(const ListNode* a, const ListNode* b) const{
            return a->val > b->val;
            }
        };
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<ListNode*, vector<ListNode*>, node_cmp> pq;
        for(ListNode* head : lists){
            if(head)
                pq.push(head);
        }
        
        ListNode* answer = new ListNode();
        ListNode* curr = answer;
        while(!pq.empty()){
            ListNode* min = pq.top(); pq.pop();
            curr->next = min;
            curr = curr->next;
            if(min->next)
                pq.push(min->next);
        }
        return answer->next;
    }
};

// Brute-Force
// Time Complexity -> O(n*k).
// Space Complexity -> O(k)
// Problems faced - NO!
// It runs on Leetcode!
class Solution {
    private:
    ListNode* merge(ListNode* node1, ListNode* node2){
        ListNode* merged = new ListNode();
        ListNode* curr = merged;
        while(node1 && node2){
            if(node1->val > node2->val){
                curr->next = node2;
                node2 = node2->next;
            }else{
                curr->next = node1;
                node1 = node1->next;
            }
            curr = curr->next;
        }
         if(node1)
            curr->next = node1;
            
         if(node2)
            curr->next = node2;
        return merged->next;
    }
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode* answer = new ListNode(INT_MIN);
        for(ListNode* head : lists){
            answer = merge(head, answer);
        }
        return answer->next;
    }
};