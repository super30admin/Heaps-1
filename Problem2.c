/* Problem Statement:
Verified on leetcode

23. Merge k Sorted Lists
Hard

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

 *
 * Time Complexity : 2 x O(n) =O(n) ie O(n) for building the heap tree and heapify and then O(n) again for extracting elements
                      from the heap tree.
 * Space Complexity : O(1) excluding the result array 
 */
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

#define UININITIALIZED_VAL 9999
struct ListNode init_node = {.val = UININITIALIZED_VAL, .next = NULL };

/* Function declaration */
void heapify_after_insert(struct ListNode **arr, int root_idx);
void heapify_after_remove(struct ListNode **arr, int root_idx, int curr_size);
int insert_elem(int *curr_size, struct ListNode **arr, struct ListNode *elem);

/* Heapify after extract_min operation is performed
 * Here, after removing the top element from heap, we move the last element
 * of heap to the top and then call this function to go from top to bottom and
 * and find the correct place of the number and heapify it.
 *
 */
void heapify_after_remove(struct ListNode **list_arr, int root_idx, int curr_size) {
        int left_child = (root_idx * 2) + 1;
        int right_child = (root_idx * 2) + 2;
        int next_child_idx = 0;
        struct ListNode **arr = list_arr;
        struct ListNode *temp_var = 0;

    /* Base terminating condition for function */
    if (right_child > curr_size) {
        return;
    }
    /* if root value is greater than any of the child, then swap the values
     * and continue with next child
     */
    if (arr[left_child]->val > arr[right_child]->val) {
        next_child_idx = right_child;
    } else {
        next_child_idx = left_child;
    }
    
    if (arr[root_idx]->val > arr[next_child_idx]->val) {
        /* swap values */
        temp_var = arr[root_idx];
        arr[root_idx] = arr[next_child_idx];
        arr[next_child_idx] = temp_var;
        heapify_after_remove(arr, next_child_idx, curr_size);
    }
}

/*
 * This function adds the new element in the array which
 * is adjusted again by calling heapify function for minheap property
 *
 */
int insert_elem(int *curr_size, struct ListNode **list_arr, struct ListNode *elem) {
    int err_code = 0;
    struct ListNode **arr = list_arr;
    int idx = 0;
    
    /* If we have reached the capacity of heap, then do the following 
    * 1. If the new element to be inserted is less than the top element dont add it as in min heap of size k , the top
    * element is the kth largest element
    * 2. else, remove the top element to make space for the new element. 
    */
    arr[*curr_size] = elem;
    heapify_after_insert(arr, *curr_size);
    *curr_size = *curr_size + 1;
    return err_code;
}

/* This function starts from the last index where the element was inserted
 * and starts checking its value with the parent.
 * For min heap, its value should be greater than or equal to its parent.
 * If its not the case, swap the values and keep going to the parent in recursive
 * fashion till the root_idx 0 is reached.
 *
 *
 */
void heapify_after_insert(struct ListNode **list_arr, int root_idx) {
         struct ListNode *temp_var = 0;
        struct ListNode **arr = list_arr;
        int parent_idx = (root_idx - 1) / 2;

    /* Intentional: Not checking for NULL ptr for arr */

    /* Terminating condition for the recursive function */
    if (root_idx == 0) {
        return;
    }
    /* If parent has higher value than child, time to swap it */
    if (arr[root_idx]->val < arr[parent_idx]->val) {
        temp_var = arr[root_idx];
        arr[root_idx] = arr[parent_idx];
        arr[parent_idx] = temp_var;
        heapify_after_insert(arr, parent_idx);
    }
}


/* This function removes the top element from the heap
 * and then readjusts using heapify function.
 */
void extract_min(struct ListNode **list_arr, int *curr_size, struct ListNode **head_ptr, struct ListNode **last_ptr) {
    struct ListNode **arr = list_arr;
    struct ListNode *temp_ptr = NULL;
    
    /* Don't call with size 0 */
    /* Book keeping for the final head pointer */
    if (*head_ptr == NULL) {
        *head_ptr = arr[0];
        *last_ptr = *head_ptr;
    } else {
        (*last_ptr)->next = arr[0];
        *last_ptr = (*last_ptr)->next;
    }
    (*last_ptr)->next = NULL;
    
    /* Replace root value with last element in array and then heapify */
    if (*curr_size >= 1) {
        arr[0] = arr[*curr_size - 1];
        arr[*curr_size - 1] = &init_node;
    }
    
    *curr_size = *curr_size - 1;
    heapify_after_remove(arr, 0, *curr_size);
}

struct ListNode* mergeKLists(struct ListNode** lists, int listsSize){
    struct ListNode **heap_arr = NULL;
    struct ListNode *head_ptr = NULL, *last_ptr = NULL;
    struct ListNode** lists_temp = lists;
    int idx = 0, idx1 = 0;
    int curr_size = 0, size = 0;
    
    if (!listsSize) {
        return NULL;
    }
    /* Prepare heap list */
    heap_arr = (struct ListNode **)malloc(sizeof(struct ListNode) * 6000);
    
    /* initialize the list */
    for (idx = 0; idx < 6000; idx++) {
        heap_arr[idx] = &init_node;
    }
    /* traverse the linked lists and then add the pointers in the heap array */
    /*
            Your input
            [[1,4,5],
            [1,3,4],
            [2,6]]
            Extracted Output
            [1,1,2,3,4,4,5,6]

    */
    for (idx = 0; idx < listsSize; idx++) {
        head_ptr = lists_temp[idx];
        while(head_ptr != NULL) {
            insert_elem(&curr_size, heap_arr, head_ptr);
            head_ptr = head_ptr->next;
        }
    }

    /* Time to retrieve all the numbers and then return the output */
    head_ptr = NULL;
    while(curr_size > 0) {
        extract_min(heap_arr, &curr_size, &head_ptr, &last_ptr);
    }
        
    free(heap_arr);
    return head_ptr;
}



/* Execute on leetcode platform */


