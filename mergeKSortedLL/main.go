/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
/*
Anything kth type question == see if heap can be of the answer
if heap is the answer, then sorting can also be another answer
*/
func mergeKLists(lists []*ListNode) *ListNode {
	if lists == nil || len(lists) == 0 {return nil}
	mn := &minHeap{items: []int{}}
	for _, list := range lists {
		for list != nil {
			heap.Push(mn, list.Val)
			list = list.Next
		}
	}
	out := &ListNode{Val: 0}
	currentOut := out
	for mn.Len() != 0 {
		popped := heap.Pop(mn).(int)
		currentOut.Next = &ListNode{Val: popped}
		currentOut = currentOut.Next
	}
	return out.Next
}

type minHeap struct {
	items []int
}
func (m *minHeap) Swap(i, j int) { m.items[i],m.items[j] = m.items[j], m.items[i]}
func (m *minHeap) Less(i, j int) bool {return m.items[i] < m.items[j]}
func (m *minHeap) Len() int {return len(m.items)}
func (m *minHeap) Push(x interface{}) {m.items = append(m.items, x.(int))}
func (m *minHeap) Pop()interface{} {
	out := m.items[len(m.items)-1]
	m.items = m.items[:len(m.items)-1]
	return out
}
