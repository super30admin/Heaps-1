//Time Complexity O(nlogn)
// Space Complexity O(n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;





  struct ListNode {
      int val;
      ListNode *next;
      ListNode() : val(0), next(nullptr) {}
     ListNode(int x) : val(x), next(nullptr) {}
     ListNode(int x, ListNode *next) : val(x), next(next) {}
  };
 
struct compare{
  bool operator() (ListNode* a, ListNode* b){
      return a->val > b->val;
  }
};

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<ListNode*, vector<ListNode*>, compare> pq;
        
        for(auto &list:lists)
        {
            if(list!=NULL)
            {
                pq.push(list);
            }
        }
        
        ListNode* dummy= new ListNode(-1);
        ListNode* current=dummy;
        
        
        while(!pq.empty())
        {
            ListNode* minNode= pq.top();
            pq.pop();
            if(minNode->next!=NULL)
            {
                pq.push(minNode->next);
            }
            current->next=minNode;
            current=minNode;
        }
        return dummy->next;
    }
};