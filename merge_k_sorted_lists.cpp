//Time Complexity-O(nklogk)
//Space Complexity-O(k)
//Ran successfully on leetcode
//3 point algo -
	//1.Add heads of the linked lists to the priority queue with max heap implementation
	//2.Take a temp node to point to the top of the queue i.e. it will point to the min element. Pop it out and make the result point to the popped node.
	//3.Push the next node of the one just popped and repeat the process.
	//4.Since result is moving, we can assign it to some dummy node in  the beginning and move that instead. Inthe end, we can return result->next which will point to the dummy node.

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
    struct comparator
    {
        bool operator()(const ListNode* l1,const ListNode* l2)
        {
            return l1->val>l2->val;
        }
    };
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.empty())
            return {};
        priority_queue<ListNode*,vector<ListNode*>,comparator>pq;
        ListNode*dummy=new ListNode();
        ListNode*result=dummy;
        for(ListNode* head:lists)
            if(head!=NULL)
                pq.push(head);
        while(!pq.empty())
        {
            ListNode* temp=pq.top();
            pq.pop();
            dummy->next=temp;
            dummy=dummy->next;
            if(temp->next!=NULL)
                pq.push(temp->next);
        }
        return result->next;
    }
};