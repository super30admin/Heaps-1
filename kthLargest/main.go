// sorting is always there -- sort nums and then return last kth element - but time would be o(nlogn)
// instead we can use minHeap
// time: o(nlogk)
// we loop over all numbers in nums o(n)
// we store them in heap but our insert/extract only ever has to deal with k items in heap therefore logk
// therefore total time: o(n) * o(logk) = o(nlogk)
// space: o(k) - at worse we store k elements in our min heap
func findKthLargest(nums []int, k int) int {
	var out int
	if nums == nil {
		return -1
	}
	mn := &MinHeap{items: []int{}}
	for _, e := range nums {
        heap.Push(mn, e)
        if len(mn.items) > k {heap.Pop(mn)}
	}
	out = mn.items[0]
	return out
}

// implements container heap interface : https://pkg.go.dev/container/heap#Interface
type MinHeap struct {
	items []int
}

func (m *MinHeap) Len() int {return len(m.items)}
func (m *MinHeap) Less(i, j int) bool {return m.items[i] < m.items[j]}
func (m *MinHeap) Swap(i, j int) { m.items[i],m.items[j] = m.items[j], m.items[i]}
func (m *MinHeap) Push(x interface{}) {m.items = append(m.items, x.(int))}
func (m *MinHeap) Pop() interface{} {
	i := m.items[len(m.items)-1]
	m.items = m.items[:len(m.items)-1]
	return i
}
