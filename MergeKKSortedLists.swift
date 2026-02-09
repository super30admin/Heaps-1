//
//  MergeKSortedLists.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 2/5/26.
//

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public var val: Int
 *     public var next: ListNode?
 *     public init() { self.val = 0; self.next = nil; }
 *     public init(_ val: Int) { self.val = val; self.next = nil; }
 *     public init(_ val: Int, _ next: ListNode?) { self.val = val; self.next = next; }
 * }
 */


class MeregeKSortedLists {
    
    struct PriorityQueue<T> {

        var elements: [T] = []
        let sort: (T, T) -> Bool

        init(sort: @escaping (T, T) -> Bool) {
            self.sort = sort
        }

        var isEmpty: Bool {
            return elements.isEmpty
        }

        var count: Int {
            return elements.count
        }
        
        var peek: T? {
            return elements.first
        }

        mutating func enqueue(_ val: T) {
            elements.append(val)
            heapifyUp(from: elements.count - 1)
        }

        mutating func heapifyUp(from index: Int) {
            var childIndex = index
            var parentIndex = (index - 1)/2
            while (childIndex > 0 && sort(elements[childIndex], elements[parentIndex])) {
                elements.swapAt(childIndex, parentIndex)
                childIndex = parentIndex
                parentIndex = (childIndex - 1)/2
            }
        }

        mutating func dequeue() -> T? {
            if (elements.isEmpty) {
                return nil
            }

            elements.swapAt(0, elements.count - 1)
            let element = elements.removeLast()
            heapifyDown(from: 0)

            return element
        }

        mutating func heapifyDown(from index: Int) {
            var parentIndex = index
            var leftChildIndex = 2 * parentIndex + 1
            
            while (leftChildIndex < count) {
                var childIndex = leftChildIndex
                let rightChildIndex = leftChildIndex + 1
                
                //pick higher priority child
                if (rightChildIndex < count && sort(elements[rightChildIndex], elements[leftChildIndex])) {
                    childIndex = rightChildIndex
                }
                
                //if parent has greater priority then, break the loop
                if (sort(elements[parentIndex], elements[childIndex])) {
                    break
                }
                
                elements.swapAt(childIndex, parentIndex)
                parentIndex = childIndex
                leftChildIndex = parentIndex * 2 + 1
            }
        }
    }

    /*
     Time compelxity - O(N logk)
     space complexity - O(k)
     
     
     */
    func mergeKLists(_ lists: [ListNode?]) -> ListNode? {

        var pq: PriorityQueue<ListNode> = PriorityQueue<ListNode>(sort: {$0.val < $1.val})
                
        for head in lists {
            if let head = head {
                pq.enqueue(head)
            }
        }
        var dummy = ListNode(-1)
        var curr =  dummy
        while (!pq.isEmpty) {
            let min = pq.dequeue()
            curr.next = min
            curr = curr.next!

            if (min?.next != nil) {
                pq.enqueue(min!.next!)
            }
        }
        return dummy.next
    }
    
    /*
     Merge two lists, then merge the resulted list to the thirs list.... and so on
     time complexity - O(N *k) solution , N = k*n
     SPace complexity - O(1)
     */
    func mergeKListsWithNonOptimalSolution(_ lists: [ListNode?]) -> ListNode? {
        var merged = ListNode(Int.min)
        
        for head in lists {
             merged = merge(head1: merged, head2: head)
        }
        return merged.next
    }

    func merge(head1: ListNode?, head2: ListNode?) -> ListNode {
        var head1 = head1
        var head2 = head2
        var dummy = ListNode(-1)
        var curr = dummy
        while (head1 != nil && head2 != nil) {
            if (head1!.val < head2!.val) {
                curr.next = head1
                head1 = head1!.next
            } else {
                curr.next = head2
                head2 = head2!.next
            }
            curr = curr.next!
        }
        if (head1 != nil) {
            curr.next = head1
        } else {
            curr.next = head2
        }
         return dummy.next!
    }

    
}
