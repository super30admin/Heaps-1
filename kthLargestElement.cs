using System;
using System.Collections.Generic;
using System.Text;

namespace Design
{
    public class kthLargestElement
    {
        /*
         * T.C : O(NLogk)
         * S.C: O(K)
         * 
         */
        public int FindKthLargest1(int[] nums, int k)
        {
            PriorityQueue<int, int> queue = new PriorityQueue<int, int>();
            

            foreach (var num in nums)
            {

                queue.Enqueue(num, num);
                if (queue.Count > k)
                {
                    queue.Dequeue();
                }


            }

            return queue.Dequeue();
        }




        // Max heap method
        class Comparer : IComparer<int>
        {
            public int Compare(int num1, int num2)
            {

                return num2 - num1;
            }
        }

        public int FindKthLargest2(int[] nums, int k)
        {
            PriorityQueue<int, int> queue = new PriorityQueue<int, int>(new Comparer());
            int result = int.MaxValue;
            int n = nums.Length;
            foreach (var num in nums)
            {

                queue.Enqueue(num, num);
                if (queue.Count > n - k)
                {
                    result = Math.Min(result, queue.Dequeue());
                }


            }

            return result;
        }
    }
}
