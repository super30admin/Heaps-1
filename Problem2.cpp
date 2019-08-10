//
// Created by shazm on 8/9/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <priority_queue>

using namespace std;
struct ListNode {
     int val;
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<int> queue;
        ListNode* head = NULL;
        if(lists.empty()){return head;}
        for(int x = 0; x<lists.size(); x++){
            head = lists[x];
            while(head!=NULL){
                queue.push(head->val);
                head = head->next;
            }
        }
        head = NULL;
        while(!queue.empty()){
            ListNode* node = new ListNode(queue.top());
            node->next = head;
            head = node;
            queue.pop();
        }
        return head;
    }
};