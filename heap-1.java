//approach-we traversed the array started putting the elements in a min heap while restricting the size of the heap to k. once the size goes over k that mean we have a min amount k+1 items on the top ==> there are k items larger than the root which implies we dont need the root and we pop it. we do that till we reach the end of array. at that point the root of the min heap would have the kth largest element as our heap size is k and the min amoung the k elements would be the kth largest.
//time complexity-O(n*k) n=nums.length();
//space complexity-O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int i : nums) {
            p.add(i);
            if (p.size() > k)
                p.poll();
        }
        return p.peek();
    }

}
