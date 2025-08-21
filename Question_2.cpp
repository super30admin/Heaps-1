#include<queue>
#include <vector>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
struct ListNodeComp {
    bool operator()(ListNode* a, ListNode* b) {
        return a->val > b->val; // Min-heap based on node values
    }
};
ListNode* mergeKLists(vector<ListNode*>& lists) {
    priority_queue<ListNode*,vector<ListNode*>,ListNodeComp>min_heap;
    int n = lists.size();
    for(int i=0;i<=n-1;i++){
        if(lists[i])min_heap.push(lists[i]);
    }
    ListNode* head = NULL,*ans = NULL;
    while(!min_heap.empty()){
        ListNode*top = min_heap.top();
        min_heap.pop();
        if(!head) ans = head = top;
        else {
            head->next = top;
            head = head->next;
        }
        if(top->next) min_heap.push(top->next);
        head->next = NULL;
    }
    return ans;

}
int main() {
    // Example usage
    ListNode* l1 = new ListNode(1);
    l1->next = new ListNode(4);
    l1->next->next = new ListNode(5);
    
    ListNode* l2 = new ListNode(1);
    l2->next = new ListNode(3);
    l2->next->next = new ListNode(4);
    
    ListNode* l3 = new ListNode(2);
    l3->next = new ListNode(6);
    
    vector<ListNode*> lists = {l1, l2, l3};
    
    ListNode* mergedList = mergeKLists(lists);
    
    // Print merged list
    while (mergedList) {
        cout << mergedList->val << " ";
        mergedList = mergedList->next;
    }
    
    return 0;
}
// Time complexity: O(k+n log k) 
// Space complexity: O(k)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No
// Your code here along with comments explaining your approach in three sentences only
// min-heap to push the smallest element in all lists to the heap, and as we keep popping the elements, add
// the next element of the popped element to the heap, and keep track of the head of the merged list.
// Finally, return the head of the merged list.