// Approach 1: Min Heaps
// Time Complexity : O(n logk) - where n is the average number of nodes in the list and k is the number of lists
// Space Complexity : O(k) for the heap
// Did this code successfully run on Leetcode : Yes 

// Add all the first nodes of the LLs to a min heap
// Get the smallest from heap, and add the next node in that list 

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


class Comparator {
public:
    //overloading the operator() for the comparison  
    // primitive way if looking at the logic behind operator() 
    // - return true is re-arraging is required 
    // - return false if the new node can just be added without any changes
    bool operator() (ListNode* nodeA, ListNode* nodeB) {
        return (nodeA->val > nodeB->val);
    }
};
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<ListNode*, vector<ListNode*>, Comparator> pq;
        //creating a dummy head
        ListNode* head = new ListNode(-1);
        ListNode* curr = head;

        // adding all the first nodes to the min-heap 
        for(auto ll : lists){
            if(ll != NULL)
                pq.push(ll);
        }

        // while the heap still has nodes 
        // keeps reducing as we are not adding NULL nodes
        while(pq.size()){
            // pop the smallest node and push the next node from that LL
            // add the popped node to the result LL
            ListNode* temp = pq.top();
            ListNode* newNode = new ListNode(temp->val);
            curr->next = newNode;
            curr = newNode;
            pq.pop();
            if(temp->next != NULL)
                pq.push(temp->next);
        }

        // return the LL
        return head->next;
    }
};


// Approach 2: Brute Force

// Time Complexity : O(nk^2) - going over all the nodes once
// Space Complexity : O(1) - no additional space
// Did this code successfully run on Leetcode : Yes 

// Combine 2 lists at each time and run it k times 
// Time to combine 2 lists: n + n
// Time to combine the resultant with a new list: 2n + n
// Time to combine all lists: n + 2n + 3n + 4n + ... + kn = O(nk^2)

// Approach 2: Brute force 
// TC: O(nk^2)

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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.size() == 0) return (NULL);
        ListNode* resultHead = new ListNode(INT_MIN);
        
        for(ListNode* list: lists)
            resultHead = merge2Lists(resultHead, list);

        return resultHead->next;
    }

private:
    ListNode* merge2Lists(ListNode* l1, ListNode* l2){
        ListNode* dummy = new ListNode(INT_MIN);
        ListNode* curr = dummy;
        while(l1 != NULL && l2 != NULL){
            if(l1->val < l2->val){
                curr->next = l1;
                l1 = l1->next;
            }
            else {
                curr->next = l2;
                l2 = l2->next;
            }
            curr = curr->next;
        }
        if(l1 != NULL)
            curr->next = l1;
        else
            curr->next = l2;

        return dummy->next;
    }
};