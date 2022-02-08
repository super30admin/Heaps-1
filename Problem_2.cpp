/**
 * Time Complexity:
 * O(nklogk) wher ek is the number of linked lists 
 * 
 */

/**
 * Space Complexity:
 * The space complexity os O(1) as we are not creating any extra space
 */


/**
 * Approach:
 * the first intution is brute force but it is not optimized solution.
 * The second thing that comes to mind is heap. But the space complexity is
 * not optimized in it. So, we go for a third approach. Here we are merging the
 * lists one by one. The merging algorithm here is same as of merging two linked lists.
 * First we compare the values of the nodes of two lists. Whichever value is smaller
 * we take that value first and then we move to the next node of the list whose value
 * was taken in the previous step and compare it's value with the same value of the list
 * which was taken in the last step. AGain based on the comparison the values are added.
 * 
 * We have to take care of the case where one of the list is smaller than the other list.
 */
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode *merged = new ListNode(INT_MIN);
        for(auto node : lists){
            merged = merge(merged, node);
        }
        return merged->next;  
    }
    
    private:
     ListNode* merge(ListNode* h1, ListNode* h2){
         ListNode* dummy = new ListNode(-1);
        ListNode* curr = dummy; 
         while(h1 != nullptr && h2 != nullptr){
             if(h1->val < h2-> val){
                 curr->next = h1;
                 h1 = h1->next;
             } else {
                 curr->next =h2;
                 h2 = h2->next;
             }
             curr = curr->next;
         }
         if(h1 != nullptr){
             curr->next = h1;
         }
          if(h2 != nullptr){
             curr->next = h2;
         }
         
         return dummy->next;
     }
};