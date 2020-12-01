// Time Complexity : O(nk2)
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
insert heads of all lists into heap
have a dummy node and a result node
then while heap is not empty extract minimum from heap and set it to dummy.Next
insert dummy.Next into the heap
return result.Next
*/
package main

import (
	"fmt"
	"log"
)

type ListNode struct {
      Val int
      Next *ListNode
}

type Heap1 struct {
	Items []*ListNode
}

func (h *Heap1) GetLeftIndex1(index int) int {
	return index * 2 + 1
}

func (h *Heap1) GetRightIndex1(index int) int {
	return index * 2 + 2
}

func (h *Heap1) GetParentIndex1(index int) int {
	return (index - 1) / 2
}

func (h *Heap1) HasLeft1(index int) bool {
	return h.GetLeftIndex1(index) < len(h.Items)
}

func (h *Heap1) HasRight1(index int) bool {
	return h.GetRightIndex1(index) < len(h.Items)
}

func (h *Heap1) HasParent1(index int) bool {
	return h.GetParentIndex1(index) >= 0
}

func (h *Heap1) GetLeft1(index int) *ListNode {
	return h.Items[h.GetLeftIndex1(index)]
}

func (h *Heap1) GetRight1(index int) *ListNode {
	return h.Items[h.GetRightIndex1(index)]
}

func (h *Heap1) GetParent1(index int) *ListNode {
	return h.Items[h.GetParentIndex1(index)]
}

func (h *Heap1) Swap1(index1, index2 int) {
	h.Items[index1], h.Items[index2] = h.Items[index2], h.Items[index1]
}


type MinHeap1 struct {
	*Heap1
}

func Constructor1(nums []*ListNode) *MinHeap1 {
	mh := &MinHeap1{
		&Heap1{
			Items: nums,
		},
	}

	if len(nums) > 0 {
		mh.buildMinHeap1()
	}
	return mh
}

func (mh *MinHeap1) buildMinHeap1() {
	for i:= (len(mh.Items) / 2) - 1; i >= 0; i-- {
		mh.minHeapifyDown1(i)
	}
}

func (mh *MinHeap1) InsertToMinHeap1(num *ListNode) *MinHeap1 {
	mh.Items = append(mh.Items, num)
	mh.minHeapifyUp1(len(mh.Items) - 1)
	return mh
}

func (mh *MinHeap1) ExtractMin1() *ListNode {
	if len(mh.Items) == 0 {
		log.Fatal("empty heap")
	}
	min := mh.Items[0]
	mh.Items[0] = mh.Items[len(mh.Items) - 1]
	mh.Items = mh.Items[:len(mh.Items) - 1]
	mh.minHeapifyDown1(0)
	return min
}

func (mh *MinHeap1) PeekMin1() *ListNode {
	if len(mh.Items) == 0 {
		log.Fatal("empty heap")
	}
	return mh.Items[0]
}

func (mh *MinHeap1) minHeapifyDown1(index int) {
	for (mh.HasLeft1(index) && mh.Items[index].Val > mh.GetLeft1(index).Val)  || (mh.HasRight1(index) && mh.Items[index].Val > mh.GetRight1(index).Val) {
		if mh.HasLeft1(index) && mh.Items[index].Val > mh.GetLeft1(index).Val && mh.HasRight1(index) && mh.Items[index].Val > mh.GetRight1(index).Val {
			if mh.GetLeft1(index).Val < mh.GetRight1(index).Val {
				mh.Swap1(index, mh.GetLeftIndex1(index))
				index = mh.GetLeftIndex1(index)
			} else {
				mh.Swap1(index, mh.GetRightIndex1(index))
				index = mh.GetRightIndex1(index)
			}
		} else if mh.HasLeft1(index) && mh.Items[index].Val > mh.GetLeft1(index).Val {
			mh.Swap1(index, mh.GetLeftIndex1(index))
			index = mh.GetLeftIndex1(index)
		} else {
			mh.Swap1(index, mh.GetRightIndex1(index))
			index = mh.GetRightIndex1(index)
		}
	}
}

func (mh *MinHeap1) minHeapifyUp1(index int) {
	for mh.HasParent1(index) && mh.GetParent1(index).Val > mh.Items[index].Val {
		mh.Swap1(index, mh.GetParentIndex1(index))
		index = mh.GetParentIndex1(index)
	}
}


func mergeKLists(lists []*ListNode) *ListNode {
	dummy := &ListNode{}
	result := dummy
	mh := Constructor1([]*ListNode{})
	for i:=0;i<len(lists);i++ {
		if lists[i] != nil {
			mh.InsertToMinHeap1(lists[i])
		}
	}
	for len(mh.Items) > 0 {
		dummy.Next = mh.ExtractMin1()
		dummy = dummy.Next
		if dummy.Next != nil {
			mh.InsertToMinHeap1(dummy.Next)
		}
	}
	return result.Next
}

func MainMergeKLists() {
	//[[1,4,5],[1,3,4],[2,6]]
	x := []*ListNode{&ListNode{Val: 1, Next: &ListNode{Val: 4, Next:&ListNode{Val: 5}}}, &ListNode{Val: 1, Next:&ListNode{Val:3, Next:&ListNode{Val:4}}}, &ListNode{Val:2, Next:&ListNode{Val:6}}}
	fmt.Println(mergeKLists(x)) //expected 1
}