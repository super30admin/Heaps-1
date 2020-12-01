package main

import (
	"fmt"
	"log"
)

type ListNode2 struct {
	Index int
	Distance float64
}

type Heap2 struct {
	Items []*ListNode2
}

func (h *Heap2) GetLeftIndex2(index int) int {
	return index * 2 + 1
}

func (h *Heap2) GetRightIndex2(index int) int {
	return index * 2 + 2
}

func (h *Heap2) GetParentIndex2(index int) int {
	return (index - 1) / 2
}

func (h *Heap2) HasLeft2(index int) bool {
	return h.GetLeftIndex2(index) < len(h.Items)
}

func (h *Heap2) HasRight2(index int) bool {
	return h.GetRightIndex2(index) < len(h.Items)
}

func (h *Heap2) HasParent2(index int) bool {
	return h.GetParentIndex2(index) >= 0
}

func (h *Heap2) GetLeft2(index int) *ListNode2 {
	return h.Items[h.GetLeftIndex2(index)]
}

func (h *Heap2) GetRight2(index int) *ListNode2 {
	return h.Items[h.GetRightIndex2(index)]
}

func (h *Heap2) GetParent2(index int) *ListNode2 {
	return h.Items[h.GetParentIndex2(index)]
}

func (h *Heap2) Swap1(index1, index2 int) {
	h.Items[index1], h.Items[index2] = h.Items[index2], h.Items[index1]
}


type MaxHeap1 struct {
	*Heap2
}

func Constructor2(nums []*ListNode2) *MaxHeap1 {
	mh := &MaxHeap1{
		&Heap2{
			Items: nums,
		},
	}

	if len(nums) > 0 {
		mh.buildMaxHeap1()
	}
	return mh
}

func (mh *MaxHeap1) buildMaxHeap1() {
	for i:= (len(mh.Items) / 2) - 1; i >= 0; i-- {
		mh.maxHeapifyDown1(i)
	}
}

func (mh *MaxHeap1) InsertToMaxHeap1(num *ListNode2) *MaxHeap1 {
	mh.Items = append(mh.Items, num)
	mh.maxHeapifyUp1(len(mh.Items) - 1)
	return mh
}

func (mh *MaxHeap1) ExtractMax1() *ListNode2 {
	if len(mh.Items) == 0 {
		log.Fatal("empty heap")
	}
	min := mh.Items[0]
	mh.Items[0] = mh.Items[len(mh.Items) - 1]
	mh.Items = mh.Items[:len(mh.Items) - 1]
	mh.maxHeapifyDown1(0)
	return min
}

func (mh *MaxHeap1) PeekMax1() *ListNode2 {
	if len(mh.Items) == 0 {
		log.Fatal("empty heap")
	}
	return mh.Items[0]
}

func (mh *MaxHeap1) maxHeapifyDown1(index int) {
	for (mh.HasLeft2(index) && mh.Items[index].Distance < mh.GetLeft2(index).Distance)  || (mh.HasRight2(index) && mh.Items[index].Distance < mh.GetRight2(index).Distance) {
		if mh.HasLeft2(index) && mh.Items[index].Distance < mh.GetLeft2(index).Distance && mh.HasRight2(index) && mh.Items[index].Distance < mh.GetRight2(index).Distance {
			if mh.GetLeft2(index).Distance > mh.GetRight2(index).Distance {
				mh.Swap1(index, mh.GetLeftIndex2(index))
				index = mh.GetLeftIndex2(index)
			} else {
				mh.Swap1(index, mh.GetRightIndex2(index))
				index = mh.GetRightIndex2(index)
			}
		} else if mh.HasLeft2(index) && mh.Items[index].Distance < mh.GetLeft2(index).Distance {
			mh.Swap1(index, mh.GetLeftIndex2(index))
			index = mh.GetLeftIndex2(index)
		} else {
			mh.Swap1(index, mh.GetRightIndex2(index))
			index = mh.GetRightIndex2(index)
		}
	}
}

func (mh *MaxHeap1) maxHeapifyUp1(index int) {
	for mh.HasParent2(index) && mh.GetParent2(index).Distance < mh.Items[index].Distance {
		mh.Swap1(index, mh.GetParentIndex2(index))
		index = mh.GetParentIndex2(index)
	}
}


func kClosest(points [][]int, K int) [][]int {
	n := len(points)
	h := Constructor2([]*ListNode2{})
	for i:=0;i<n;i++ {
		d := distanceFromOrigin(points[i][0], points[i][1])
		ln := &ListNode2{
			Index: i,
			Distance: d,
		}
		h.InsertToMaxHeap1(ln)
		if len(h.Items) > K {
			h.ExtractMax1()
		}
	}
	res := [][]int{}
	p := len(h.Items)
	for i:=0;i<p;i++{
		x := h.ExtractMax1().Index
		res = append(res, points[x])
	}
	return res
}

func distanceFromOrigin(x, y int) float64 {
	return float64(x*x + y*y)
}

func MainKClosest() {
	fmt.Print(kClosest([][]int{{6,10},{-3,3},{-2,5},{0,2}}, 3))
}
