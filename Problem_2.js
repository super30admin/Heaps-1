// Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)

// Time Complexity : O(k^2 n)
// Space Complexity : O(kn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

var merge = function (ll1, ll2) {
    let dummy = new ListNode(-Infinity);
    let result = dummy;
    while (ll1 !== null && ll2 !== null) {
        if (ll1.val < ll2.val) {
            result.next = ll1;
            ll1 = ll1.next;
        } else {
            result.next = ll2;
            ll2 = ll2.next
        }
        result = result.next;
    }
    if (ll1 !== null)
        result.next = ll1;
    if (ll2 !== null)
        result.next = ll2;

    return dummy.next;
}
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function (lists) {
    if (lists === null || lists.length === 0)
        return null;
    if (lists.length === 1)
        return lists[0];

    let result = lists[0];
    for (let i = 1; i < lists.length; i++)
        result = merge(result, lists[i]);

    return result;

};
