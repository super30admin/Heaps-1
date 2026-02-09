//
//  KthLargestElementInArray.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 2/4/26.
//

class KthLargestElementInArray {
    
    struct PriorityQueue<T: Comparable> {
        
        private var elements: [T] = []
        private let sort: (T, T) -> Bool
        
        init(sort: @escaping (T, T) -> Bool, elements: [T] = []) {
            self.sort = sort
            self.elements = elements
        }
        
        var isEmpty: Bool {
            return elements.isEmpty
        }
        
        var count: Int {
            return elements.count
        }
        
        func peek() -> T? {
            return elements.first
        }
        
        mutating func enqueue(_ value: T) {
            elements.append(value)
            heapifyUp(from: elements.count - 1)
        }
        
        mutating func heapifyUp(from index: Int) {
            var childIndex = index
            var parentIndex = (childIndex - 1) / 2
            while (childIndex > 0 && sort(elements[childIndex], elements[parentIndex])) {
                elements.swapAt(childIndex, parentIndex)
                childIndex = parentIndex
                parentIndex = (childIndex - 1) / 2
            }
        }
        
        mutating func dequeue() -> T? {
            if elements.isEmpty {
                return nil
            }
            elements.swapAt(0, elements.count - 1)
            let element = elements.removeLast()
            heapifyDown(from: 0)
            return element
        }
        
        mutating func heapifyDown(from index: Int) {
            var parentIndex = index
            while true  {
                var childIndex = 2 * parentIndex + 1
                
                //if child is out of the bounds, break
                if childIndex >= count {
                    break
                }
                
                //if right child exists and right child has higher priority than the left child, then go to the right child
                if ((childIndex + 1) < count && sort(elements[childIndex + 1], elements[childIndex])) {
                    childIndex += 1
                }
                
                //If priority of parent is greater than the better child then break.
                if (sort(elements[parentIndex], elements[childIndex])) {
                    break
                }
                
                //If parent's priority is lesser than the child then swap both
                elements.swapAt(parentIndex, childIndex)
                parentIndex = childIndex
                
            }
        }
    }

    /*
     time complexity - n(logk)
     space complexity - O(k)
     using min heap - We are keeping the capacity of the heap as k. If after addition of next element, the capcity goes above k, then dequeue. Dequeue will remove the minimum of all k elements in head. The on top of heap, we will have the kth largest element in the whole array. Because all elements lesser than kth element has been dequeued.
     */
    func findKthLargest(_ nums: [Int], _ k: Int) -> Int {
        var priorityQueue = PriorityQueue<Int>(sort: <)
        for num in nums {
            priorityQueue.enqueue(num)
            if (priorityQueue.count > k) {
                let _ = priorityQueue.dequeue()
            }
        }
        return priorityQueue.peek() ?? -1
    }
    
    /*
     Using max heap - here we need to maintain the heap size as (n - k), then we can remove all elements greater than the kth largest element from the heap. Heap will contain all elements lesser than k and kth element. Then we can return top element as the kth largest.
     time complexity -> n * log(n - k)
     space complexity -> O(n - k)
     */
    
    func findKthLargestUsingMaxHeap(_ nums: [Int], _ k: Int) -> Int {
        //max heap
        var result = Int.max
        var priorityQueue = PriorityQueue<Int>(sort: { a, b in
            a > b
        }, elements: [])
        for num in nums {
            priorityQueue.enqueue(num)
            if (priorityQueue.count > (nums.count - k)) {
                //priorityQueue.dequeue() is among the top k elements. I need to get the minimum in top k elements. Hence, the min function.
                result = min(priorityQueue.dequeue()!, result)
            }
        }
        return result
    }
}
