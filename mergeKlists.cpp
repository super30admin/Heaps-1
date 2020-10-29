// Time - O(NlogK)
// Space - O(K * Max_Len_LinkedList)
// Leetcode -yes
// Problems - no
class Solution
{
public:
    ListNode *mergeKLists(vector<ListNode *> &lists)
    {
        if (lists.empty() || lists.size() == 0)
        {
            return NULL;
        }

        struct comp{
            bool operator()(ListNode *a, ListNode *b) {
                return a->val > b->val;
            }
        };

        priority_queue<ListNode *, vector<ListNode *>, comp> pq;
        for (int i = 0; i < lists.size(); i++)
        {
            if (lists[i])
            {
                pq.push(lists[i]);
            }
        }

        ListNode dummyHead(0);
        ListNode *tail = &dummyHead;

        // Simply start popping the nodes from the heap and keep adding them to the list;
        while (!pq.empty())
        {
            auto temp = pq.top();
            pq.pop();

            // Add it to the list
            tail->next = temp;
            tail = tail->next;

            // if there are more nodes attached to this node in the list, move them all to pq
            if (temp->next)
            {
                pq.push(temp->next);
            }
        }

        // Make sure you set the next pointer of the last added node to NULL, for memory leak
        tail->next = NULL;
        return dummyHead.next;
    }
};