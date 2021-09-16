using System;
using System.Collections.Generic;
using System.Text;

namespace Heaps
{
    class KthLargestElementLC
    {
        //Priority Queue:
        //Insert: O(logk)
        //GetMin: O(1)
        //ExtractMin: O(logk)
        //Remove O(logk)
        //Heapify O(logk)

        //TC: O(nlog(k))
        //SC: O(k)
        public int FindKthLargest(int[] nums, int k)
        {
            if (nums == null || nums.Length == 0)
            {
                return -1;
            }
            PriorityQueue<int> pq = new PriorityQueue<int>(true); //default min heap will have maximum k elements after removing n-k elements. queue will have k maximum elements. if k is small , use minheap
            int i = 0;
            foreach (int num in nums)
            {
                pq.Enqueue(i,num);
                if (pq.Count > k)
                {
                    pq.Dequeue();
                }
                i++;
            }
            return pq.Peek();
        }

        //TC: O(nlog(n-k))
        //SC: O(n-k)
        public int FindKthLargestMaxHeap(int[] nums, int k)
        {
            if (nums == null || nums.Length == 0)
            {
                return -1;
            }
            // PriorityQueue<int> pq = new PriorityQueue<int>((a, b) => b - a); max heap will have n-k elements. largest elements will be removed from queue and stored in a variable to get result
            PriorityQueue<int> pq = new PriorityQueue<int>();
            int result = Int32.MaxValue;
            foreach (int num in nums)
            {
                pq.Enqueue(num);
                if (pq.Count > nums.Length - k)
                {
                    result = Math.Min(result, pq.Dequeue());
                }
            }
            return result;
        }
    }
}
