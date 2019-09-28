/* Problem Statement:
Verified on leetcode

347. Top K Frequent Elements

Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]

Note:

    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.



 *
 * Time Complexity : O(n)  (O(n) for min heap processing , O(n) for hash table addition of entries )
 * Space Complexity : O(n) hash table used to store entries  
 */


/**
 * Definition for entry 
 */

/******** HELPER FUNCTIONS FOR MIN HEAP ***/
 struct MyNode {
      int key;
      int val;
 };

#define UININITIALIZED_VAL 9999
struct MyNode init_node = {.val = UININITIALIZED_VAL, .key = 0 };

/* Function declaration */
void heapify_after_insert(struct MyNode **arr, int root_idx);
void heapify_after_remove(struct MyNode **arr, int root_idx, int curr_size);
int insert_elem(int *curr_size, struct MyNode **arr, struct MyNode *elem,int k);

 /* This function removes the top element from the heap
 * and then readjusts using heapify function.
 */
void extract_min(struct MyNode **list_arr, int *curr_size) {
        struct MyNode **arr = list_arr;
    
        if ((*curr_size == 0)) {
                return;
        }
        /* Replace root value with last element in array and then heapify */
        if (*curr_size >= 1) {
            free(arr[0]);
            arr[0] = arr[*curr_size - 1];
            arr[*curr_size - 1] = &init_node;
        } else {
            arr[0] = &init_node;
        }
        *curr_size = *curr_size - 1;
        heapify_after_remove(arr, 0, *curr_size);
}

/* Heapify after extract_min operation is performed
 * Here, after removing the top element from heap, we move the last element
 * of heap to the top and then call this function to go from top to bottom and
 * and find the correct place of the number and heapify it.
 *
 */
void heapify_after_remove(struct MyNode **list_arr, int root_idx, int curr_size) {
        int left_child = (root_idx * 2) + 1;
        int right_child = (root_idx * 2) + 2;
        int next_child_idx = 0;
        struct MyNode **arr = list_arr;
        struct MyNode *temp_var = 0;

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
int insert_elem(int *curr_size, struct MyNode **list_arr, struct MyNode *elem, int k) {
    int err_code = 0;
    struct MyNode **arr = list_arr;
    int idx = 0;
    int index1 = 0;
    
    /* If we have reached the capacity of heap, then do the following 
    * 1. If the new element to be inserted is less than the top element dont add it as in min heap of size k , the top
    * element is the kth largest element
    * 2. else, remove the top element to make space for the new element. 
    */
    if (*curr_size == k) {
        if (arr[0]->val > elem->val) {
            return err_code;
        }
        extract_min(arr, curr_size);
    }

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
void heapify_after_insert(struct MyNode **list_arr, int root_idx) {
         struct MyNode *temp_var = 0;
        struct MyNode **arr = list_arr;
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
void get_all_elements(struct MyNode **list_arr, int *curr_size, int *final_arr, int final_arr_size) {
    struct MyNode **arr = list_arr;
    
    /* Don't call with size 0 */
    while (*curr_size > 0) {
        /* Fill in reverse order :) */
        final_arr[final_arr_size] = arr[0]->key;
        final_arr_size = final_arr_size - 1;
        /* Replace root value with last element in array and then heapify */
        arr[0] = arr[*curr_size - 1];
        arr[*curr_size - 1] = &init_node;
        *curr_size = *curr_size - 1;
        heapify_after_remove(arr, 0, *curr_size);        
    }
}



/************** HASH TABLE FUNCTIONS *****/
#define HT_SIZE 10000 //hash_array table

struct hash_array
{
    int key;
    int count;
    bool valid;
    struct hash_array* next;
}hash_array[HT_SIZE];


/* Check if entry is present in hash table for the key. If yes, then return the
 * value stored for that hash table in value and return 0 or 1 based on success/failure */
int is_present_hash_table(int num, int *count)
{
    int temp = abs(num % HT_SIZE);

    if(hash_array[temp].key==num && hash_array[temp].valid == true)
    {
        *count = hash_array[temp].count;
        return 1;
    }else
    {
        struct hash_array *p=&hash_array[temp];
        while((p->key != num) && (p->next != NULL)) {
            p = p->next;
        }
        if(p->key==num && p->valid == true) {
           *count = p->count;
            return 1;
        }
        else
        {
            return 0;
        }
    }
    return 0;
}

/* Check if entry is present in hash table for the key. If yes, then return the
 * value stored for that hash table in value and return 0 or 1 based on success/failure */
int remove_hash_table_entry(int num, int *count)
{
    struct hash_array *temp_ptr = NULL;
    int temp = abs(num % HT_SIZE);

    if(hash_array[temp].valid == true && hash_array[temp].key==num)
    {
        *count = hash_array[temp].count;
        
        hash_array[temp].key = 0;
        hash_array[temp].count = 0;
        hash_array[temp].valid = false;
        return 1;
    }else
    {
        struct hash_array *p=&hash_array[temp];
        struct hash_array *prev = NULL;
        while((p->key != num) && (p->next != NULL)) {
                prev = p;
                p = p->next;
        }
        if(p->key==num && p->valid == true) {
            temp_ptr = p;
            *count = p->count;
            if (prev != NULL)
                prev->next = p->next;
            free(temp_ptr);
            return 1;
        }
        else
        {
            return 0;
        }
    }
    return 0;
}

/* Add entry in hash table. If entry exists, increment the count by 1
 * If collision occurs, then chain it in data using a linked list
 *
 */

void add_entry_hash_table(int num)
{
    int temp = abs(num % HT_SIZE);

    if(hash_array[temp].key==0) {
        hash_array[temp].key= num;
        hash_array[temp].count++;
        hash_array[temp].valid = true;

    }else if(hash_array[temp].key==num) {
        hash_array[temp].count++;
        hash_array[temp].valid = true;
    }else {

        struct hash_array *p = &hash_array[temp];

        while(p->key!=num&&p->next!=NULL) {
                p=p->next;
        }

        if(p->key==num){
                p->count++;
        }
        else
        {
            p->next=(struct hash_array*)malloc(sizeof(struct hash_array));
            p = p->next;
            p->key = num;
            p->count = 1;
            p->valid = true;
            p->next = NULL;
        }
    }
}

/****** MAIN PROGRAM */
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* topKFrequent(int* nums, int numsSize, int k, int* returnSize){
    
    struct MyNode **heap_arr = NULL, *new_entry = NULL;
    int *res_arr = NULL;
    int index = 0, index1= 0;
    int temp = 0;
    int key = 0, val = 0;
    int curr_size = 0;
    *returnSize = 0;
    
    if (!numsSize) {
        return res_arr;
    }
    
    res_arr =  (int *)malloc(sizeof(int) * k);
    if (!res_arr) {
        return NULL;
    }

    heap_arr = (struct MyNode **)malloc(sizeof(struct MyNode *) * k);
    if (!heap_arr) {
        return NULL;
    }
    
    /* Initialize hash table */
    for (index = 0; index < HT_SIZE; index++) {
        hash_array[index].key = 0;
        hash_array[index].count = 0;
        hash_array[index].next = NULL;
    }
    
    /* add into hash */
    for (index = 0; index < numsSize; index++) {
        add_entry_hash_table(nums[index]);
    }
    /* initialize heap array */
    for (index = 0; index < k; index++) {
        heap_arr[index] = &init_node;
    }
    /* Remove elements from hash table and then add it to the heap sort with frequency of number as the iterator */
    for (index = 0; index < numsSize; index++) {
        temp = 0;
        if (remove_hash_table_entry(nums[index], &temp)) {
            new_entry = (struct MyNode *)malloc(sizeof(struct MyNode));
            new_entry->key = nums[index];
            new_entry->val = temp;
            insert_elem(&curr_size, heap_arr, new_entry, k);
        }
    }
    /* get elements in reverse order from min heap to get the max output */
    get_all_elements(heap_arr, &curr_size, res_arr, k - 1);
    *returnSize = k;
    return res_arr;
}


/* Execute on leetcode platform */


