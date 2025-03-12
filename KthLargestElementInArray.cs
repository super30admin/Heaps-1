// time complexity - using minHeap- O(nlogk), using sort sort - O(nlogn)
// space complexity - O(k) for heap, for sort O(1)
public class Solution
{
    public int FindKthLargest(int[] nums, int k)
    {
        // use mean heap --nlogk
        PriorityQueue<int, int> pq = new PriorityQueue<int, int>();
        for (int i = 0; i < nums.Length; i++)
        {
            pq.Enqueue(nums[i], nums[i]);
            if (pq.Count > k)
            {
                pq.Dequeue();
            }
        }
        return pq.Dequeue();

        // sorting the array -- nlogn
        // Array.Sort(nums);
        // return(nums[nums.Length-k]);
    }
}