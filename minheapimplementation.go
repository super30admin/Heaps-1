package main

import (
	"log"
)

type Heap struct {
	Items []int
}

func (h *Heap) GetLeftIndex(index int) int {
	return index * 2 + 1
}

func (h *Heap) GetRightIndex(index int) int {
	return index * 2 + 2
}

func (h *Heap) GetParentIndex(index int) int {
	return (index - 1) / 2
}

func (h *Heap) HasLeft(index int) bool {
	return h.GetLeftIndex(index) < len(h.Items)
}

func (h *Heap) HasRight(index int) bool {
	return h.GetRightIndex(index) < len(h.Items)
}

func (h *Heap) HasParent(index int) bool {
	return h.GetParentIndex(index) >= 0
}

func (h *Heap) GetLeft(index int) int {
	return h.Items[h.GetLeftIndex(index)]
}

func (h *Heap) GetRight(index int) int {
	return h.Items[h.GetRightIndex(index)]
}

func (h *Heap) GetParent(index int) int {
	return h.Items[h.GetParentIndex(index)]
}

func (h *Heap) Swap(index1, index2 int) {
	h.Items[index1], h.Items[index2] = h.Items[index2], h.Items[index1]
}


type MinHeap struct {
	*Heap
}

func Constructor(nums []int) *MinHeap {
	mh := &MinHeap{
		&Heap{
			Items: nums,
		},
	}

	if len(nums) > 0 {
		mh.buildMinHeap()
	}
	return mh
}

func (mh *MinHeap) buildMinHeap() {
	for i:= (len(mh.Items) / 2) - 1; i >= 0; i-- {
		mh.minHeapifyDown(i)
	}
}

func (mh *MinHeap) InsertToMinHeap(num int) *MinHeap {
	mh.Items = append(mh.Items, num)
	mh.minHeapifyUp(len(mh.Items) - 1)
	return mh
}

func (mh *MinHeap) ExtractMin() int {
	if len(mh.Items) == 0 {
		log.Fatal("empty heap")
	}
	min := mh.Items[0]
	mh.Items[0] = mh.Items[len(mh.Items) - 1]
	mh.Items = mh.Items[:len(mh.Items) - 1]
	mh.minHeapifyDown(0)
	return min
}

func (mh *MinHeap) PeekMin() int {
	if len(mh.Items) == 0 {
		log.Fatal("empty heap")
	}
	return mh.Items[0]
}

func (mh *MinHeap) minHeapifyDown(index int) {
	for (mh.HasLeft(index) && mh.Items[index] > mh.GetLeft(index))  || (mh.HasRight(index) && mh.Items[index] > mh.GetRight(index)) {
		if (mh.HasLeft(index) && mh.Items[index] > mh.GetLeft(index)) && (mh.HasRight(index) && mh.Items[index] > mh.GetRight(index)) {
			if mh.GetLeft(index) < mh.GetRight(index) {
				mh.Swap(index, mh.GetLeftIndex(index))
				index = mh.GetLeftIndex(index)
			} else {
				mh.Swap(index, mh.GetRightIndex(index))
				index = mh.GetRightIndex(index)
			}
		} else if mh.HasLeft(index) && mh.Items[index] > mh.GetLeft(index) {
			mh.Swap(index, mh.GetLeftIndex(index))
			index = mh.GetLeftIndex(index)
		} else {
			mh.Swap(index, mh.GetRightIndex(index))
			index = mh.GetRightIndex(index)
		}
	}
}

func (mh *MinHeap) minHeapifyUp(index int) {
	for mh.HasParent(index) && mh.GetParent(index) > mh.Items[index] {
		mh.Swap(index, mh.GetParentIndex(index))
		index = mh.GetParentIndex(index)
	}
}