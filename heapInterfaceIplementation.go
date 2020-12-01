// This example demonstrates an integer heap built using the heap interface.
package main

import (
	"container/heap"
	"fmt"
)

type IntHeap []int

func (h IntHeap) Len() int {
	return len(h)
}

func (h IntHeap) Swap(a, b int) {
	h[a], h[b] = h[b], h[a]
}

func (h IntHeap) Less(a, b int) bool {
	return h[a] < h[b]
}

func (h *IntHeap) Push(v interface{}) {
	*h = append(*h, v.(int))
}

func (h *IntHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0:n-1]
	return x
}

func MainHeapImplementation() {
	//min heap
	mh := &IntHeap{1, 2, 3}
	heap.Init(mh)
	heap.Push(mh, 4)
	for mh.Len() > 0 {
		fmt.Printf("%d ", heap.Pop(mh))
	}

	// priority queue
	items := [][]int{{0, 30}, {5, 10}, {15, 20}}
	pq := make(PriorityQueue, len(items))
	for i:=0;i<len(items);i++ {
		pq[i] = &PQNode{
			Start: items[i][0],
			End: items[i][1],
			index: i,
		}
	}
	heap.Init(&pq)
	item := &PQNode{
		Start: 30,
		End: 40,
	}
	heap.Push(&pq, item)
	pq.update(item, item.Start, 45)
	for pq.Len() > 0 {
		item := heap.Pop(&pq).(*PQNode)
		fmt.Printf("%d:%d ", item.Start, item.End)
	}
}

type PQNode struct {
	Start int
	End int
	index int
}

type PriorityQueue []*PQNode

func (pq PriorityQueue) Len() int {
	return len(pq)
}

func (pq PriorityQueue) Less(a, b int) bool {
	return pq[a].End < pq[b].End
}

func (pq PriorityQueue) Swap(a, b int) {
	pq[a], pq[b] = pq[b], pq[a]
	pq[a].index = a
	pq[b].index = b
}

func (pq *PriorityQueue) Push(x interface{}) {
	n := len(*pq)
	item := x.(*PQNode)
	item.index = n
	*pq = append(*pq, item)
}

func (pq *PriorityQueue) Pop() interface{} {
	old := *pq
	n := len(old)
	x := old[n - 1]
	old[n - 1] = nil
	x.index = -1
	*pq = old[0:n-1]
	return x
}

func (pq *PriorityQueue) update(pqNode *PQNode, s, e int) {
	pqNode.Start = s
	pqNode.End = e
	heap.Fix(pq, pqNode.index)
}