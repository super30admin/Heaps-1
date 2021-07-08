// Time Complexity : O(N * logN) N is total number of elements
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        
        ListNode* new_root = NULL;        
        int flag = 0;
        priority_queue<int, vector<int>, greater<int>> temp = pq;
        ListNode* prev_node = new ListNode;
        
        if(lists.size() == 0)
            return new_root;
        
        priority_queue<int, vector<int>, greater<int>> pq;
        
        ListNode* root;
        ListNode* curr;
        
        for(int i = 0; i < lists.size(); i++)
        {
            root = lists[i];
            curr = root;
            
            while(curr != NULL)
            {
                pq.push(curr->val);
                
                curr = curr->next;
            }
        }
        
        while(!temp.empty())
        {   
            int value = temp.top();
            
            ListNode* new_node = new ListNode;
            
            if(flag == 0)
            {
                flag = 1;
                new_root = new_node;
            }
            
            new_node->val = value;
            
            prev_node->next = new_node;
            prev_node = new_node;
            
            temp.pop();
        }
        
        return new_root;
    }
};