//Time Complexity-O(nk)-->'n' is number of nodes and 'k' is number of linked lists
//space Complexity-O(1)
//Did the code run on Leetcode? yes

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode* dummy=new ListNode(INT_MIN);
        ListNode* res=dummy;
        for(int i=0;i<lists.size();i++)
        {
            dummy=merge(dummy,lists[i]);
        }
        return res->next;
    }
    
    ListNode* merge(ListNode* l1,ListNode* l2)
    {
        ListNode* a=new ListNode(-1);
        ListNode* b=a;
        while(l1!=NULL && l2!=NULL)
        {
            if(l1->val<l2->val)
            {
                a->next=l1;
                l1=l1->next;
            }
            else
            {
                a->next=l2;
                l2=l2->next;
            }
            a=a->next;
        }
        if(l1!=NULL)
        {
            a->next=l1;
        }
        if(l2!=NULL)
        {
            a->next=l2;
        }
        return b->next;
    }
};