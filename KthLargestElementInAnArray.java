// Time Complexity: O(nlogk)
// Space Complexity: O(n)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

        for(int num: nums) {
            pq.add(num);
        }

        int res = 0;
        while(k > 0) {
            res = pq.poll();
            k--;
        }

        return res;
    }
}