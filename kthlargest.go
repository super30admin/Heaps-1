// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
insert all elements into min heap if size if more than k then extract minimum element
return extract minimum element
*/
package main

import "fmt"

func MainKLargest() {
	fmt.Println(findKthLargest([]int{3,2,1,5,6,4}, 2))//expected 5
}

func findKthLargest(nums []int, k int) int {
	obj := Constructor([]int{})
	for i:=0;i<len(nums);i++ {
		obj.InsertToMinHeap(nums[i])
		if len(obj.Items) > k {
			obj.ExtractMin()
		}
	}
	return obj.ExtractMin()
}
