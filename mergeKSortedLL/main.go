/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

// time: o(nlogk)
// spaceL o(n)
func mergeKLists(lists []*ListNode) *ListNode {
    mn := &minHeap{nodes: []*ListNode{}}
     
    for i := 0; i < len(lists); i++ {
        if lists[i] == nil {continue}
        heap.Push(mn, lists[i])
    }
    
    out := &ListNode{Val: 0}
    tail := out
    for len(mn.nodes) != 0 {
        popped := heap.Pop(mn).(*ListNode)
        tail.Next = popped
        if popped.Next != nil {
            heap.Push(mn, popped.Next)
            popped.Next = nil
        }
        tail = tail.Next
    }
    
    return out.Next
}



/*
    container/heap
    type Interface interface {
        sort.Interface
        Pop() interface{}
        Push(x interface{})
    }
*/

type minHeap struct { nodes []*ListNode }
func (m *minHeap) Less(i, j int)bool{return m.nodes[i].Val < m.nodes[j].Val}
func (m *minHeap) Swap(i, j int){m.nodes[i],m.nodes[j] = m.nodes[j], m.nodes[i]}
func (m *minHeap) Len() int {return len(m.nodes)}
func (m *minHeap) Push(x interface{}) {m.nodes = append(m.nodes, x.(*ListNode))}
func (m *minHeap) Pop() interface{} {
    out := m.nodes[len(m.nodes)-1]
    m.nodes = m.nodes[:len(m.nodes)-1]
    return out
}
