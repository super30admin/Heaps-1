//Time Complexity-O(n*logk)--> n' is the number of nodes and 'k' is number of lists.
//Space Complexity-O(k)
//Did the code run on Leetcode? yes

class compare{
        public:
        bool operator()(ListNode* l1,ListNode* l2)
        {
            return l1->val>l2->val;
        }
    };

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode* dummy=new ListNode(-1);
        ListNode* res=dummy;
        priority_queue<ListNode*,vector<ListNode*>,compare>m;
        for(int i=0;i<lists.size();i++)
        {
            if(lists[i]!=NULL)
            {
                m.push(lists[i]);
            }
        }
        while(!m.empty())
        {
            ListNode* a=m.top();
            m.pop();
            dummy->next=a;
            if(dummy->next->next!=NULL)
            {
                m.push(dummy->next->next);
            }
            dummy=dummy->next;
            cout<<m.top()->val;
        }
        return res->next;
    }
};