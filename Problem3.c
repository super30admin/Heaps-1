/* Problem Statement:
Verified on leetcode

414. Third Maximum Number
Easy

Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:

Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.

Example 2:

Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

Example 3:

Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum

 *
 * Time Complexity : O(n)
 * Space Complexity : O(1) excluding the result array 
 */


#define UININITIALIZED_VAL 9999
bool is_dup_blocked = true;

/* Function declaration */
void heapify_after_insert(int *arr, int root_idx);
void heapify_after_remove(int *arr, int root_idx, int curr_size);
int insert_elem(int *curr_size, int *arr, int elem,int k);
void extract_min(int *arr, int *curr_size);

/* Heapify after extract_min operation is performed
 * Here, after removing the top element from heap, we move the last element
 * of heap to the top and then call this function to go from top to bottom and
 * and find the correct place of the number and heapify it.
 *
 */
void heapify_after_remove(int *arr, int root_idx, int curr_size) {
        int left_child = (root_idx * 2) + 1;
        int right_child = (root_idx * 2) + 2;
        int next_child_idx = 0;
        int temp_var = 0;

    /* Base terminating condition for function */
    if (right_child > curr_size) {
        return;
    }
    /* if root value is greater than any of the child, then swap the values
     * and continue with next child
     */
    if (arr[left_child] > arr[right_child]) {
        next_child_idx = right_child;
    } else {
        next_child_idx = left_child;
    }
    
    if (arr[root_idx] > arr[next_child_idx]) {
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
int insert_elem(int *curr_size, int *arr, int elem, int k) {
    int err_code = 0;
    int idx = 0;
    
    /* If we have reached the capacity of heap, then do the following 
    * 1. If the new element to be inserted is less than the top element dont add it as in min heap of size k , the top
    * element is the kth largest element
    * 2. else, remove the top element to make space for the new element. 
    */
    /* Don't allow duplicates */
    if (is_dup_blocked) {
        for (idx = 0; idx < k; idx++) {
            if (elem == arr[idx])
                return err_code;
        }  
    }
    if (*curr_size == k) {
        if (arr[0] > elem) {
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
void heapify_after_insert(int *arr, int root_idx) {
        int temp_var = 0;
        int parent_idx = (root_idx - 1) / 2;

    /* Intentional: Not checking for NULL ptr for arr */

    /* Terminating condition for the recursive function */
    if (root_idx == 0) {
        return;
    }
    /* If parent has higher value than child, time to swap it */
    if (arr[root_idx] < arr[parent_idx]) {
        temp_var = arr[root_idx];
        arr[root_idx] = arr[parent_idx];
        arr[parent_idx] = temp_var;
        heapify_after_insert(arr, parent_idx);
    }
}


/* This function removes the top element from the heap
 * and then readjusts using heapify function.
 */
void extract_min(int *arr, int *curr_size) {

        if ((*curr_size == 0)) {
                return;
        }
        /* Replace root value with last element in array and then heapify */
        if (*curr_size >= 1) {
            arr[0] = arr[*curr_size - 1];
            arr[*curr_size - 1] = UININITIALIZED_VAL;
        } else {
                arr[0] = UININITIALIZED_VAL;
        }
        *curr_size = *curr_size - 1;
        heapify_after_remove(arr, 0, *curr_size);
}

int thirdMax(int* nums, int numsSize){
    
    int *heap_arr = NULL;
    int idx = 0, idx1 = 0;
    int result = 0;
    int curr_size = 0;
    int k = 3; /* Third Maximum*/
    if (!numsSize) {
        return 0;
    }
    
    /* Allocate heap memory and initialize the values */
    heap_arr = (int *)malloc(sizeof(int) * k);
  
    for (idx = 0; idx < k; idx++) {
        heap_arr[idx] = UININITIALIZED_VAL;
    }
    /* insert elements in heap */
    for (idx = 0; idx < numsSize; idx++) {
        insert_elem(&curr_size, heap_arr, nums[idx], k);
    }
    /* IF only 2 elemenst, then get maximum of two numbers*/
    if (curr_size == 2) {
        return (heap_arr[0] > heap_arr[1] ? heap_arr[0]:heap_arr[1]);
    }

    /* the top element in heap will be our answer */
    result = heap_arr[0];
    
    free(heap_arr);
    
    return result;

}



/* Execute on leetcode platform */


