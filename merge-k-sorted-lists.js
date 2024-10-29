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

 //merging 2 linked lists approach
 var mergeKLists = function(lists) {
    
    let merge = function(list1, list2) {
        let dummy = new ListNode(-1);
        let curr = new ListNode();
        curr = dummy;

        while(list1 && list2) {
            if(list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            }
            else {
                curr.next = list2;
                list2 = list2.next; 
            }
            curr = curr.next;
        }
        if(list1 !== null) {
            curr.next = list1;
        }
        if(list2 !== null) {
            curr.next = list2;
        }
        return dummy.next;
    }

    let merged = new ListNode(-Infinity);
    for(let list of lists) {
        merged = merge(merged, list);
    }
    return merged.next;
};