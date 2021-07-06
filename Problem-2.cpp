//Merge K sorted lists
//PQ solution
//I'm pushing lists value in queue rather than reference, saves me trouble
//klogn approach
//O(k) space where k is no of linked lists
class Solution {
public:
    bool comp(int a,int b){
        return (a>b)?1:-1;
    }
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<int,vector<int>,comp> p;
        for(int i=0;i<lists.size();i++)
        {
            while(lists[i]!=NULL)
            {
               p.push(lists[i]->val);
                lists[i] = lists[i]->next; 
            }
        }
        ListNode* node = new ListNode(0);
        ListNode* as = node;
       while(!p.empty())
       {
           node->next = new ListNode(p.top());
           p.pop();
           node = node->next;
       }
        return as->next;
    }
};
