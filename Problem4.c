/* Problem Statement:
Verified on leetcode

703. Kth Largest Element in a Stream
Easy

Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

Example:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8


Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum

 *
 * Time Complexity : O(n)
 * Space Complexity : O(1) excluding the result array 
 */


#define UININITIALIZED_VAL 9999

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
    
    /* If we have reached the capacity of heap, then do the following 
    * 1. If the new element to be inserted is less than the top element dont add it as in min heap of size k , the top
    * element is the kth largest element
    * 2. else, remove the top element to make space for the new element. 
    */
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


typedef struct {
    int *heap_arr;
    int curr_size;
    int k;
} KthLargest;


KthLargest* kthLargestCreate(int k, int* nums, int numsSize) {
    int idx = 0;
    
    KthLargest *obj = (KthLargest *)malloc(sizeof(KthLargest));
    obj->heap_arr =  (int *)malloc(sizeof(int) * k);  /* Allocate heap memory and initialize the values */
    obj->curr_size = 0;
    obj->k = k;
    
    for (idx = 0; idx < k; idx++) {
        obj->heap_arr[idx] = UININITIALIZED_VAL;
    }
    
    /* insert elements in heap */
    for (idx = 0; idx < numsSize; idx++) {
        insert_elem(&(obj->curr_size), obj->heap_arr, nums[idx], k);
    }
    return obj;
}

int kthLargestAdd(KthLargest* obj, int val) {
    
    insert_elem(&(obj->curr_size), obj->heap_arr, val, obj->k);
    return obj->heap_arr[0];
}

void kthLargestFree(KthLargest* obj) {
    
    free(obj->heap_arr);
    free(obj);
}

/**
 * Your KthLargest struct will be instantiated and called as such:
 * KthLargest* obj = kthLargestCreate(k, nums, numsSize);
 * int param_1 = kthLargestAdd(obj, val);
 
 * kthLargestFree(obj);
*/


/* Execute on leetcode platform */


