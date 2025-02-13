# tc O(n * log k), sc O(1).
def merge_lists(l1, l2):
    sentinel = ListNode()
    l3 = sentinel
    while l1 and l2:
        if l1.val <= l2.val:
            l3.next = l1
            l1 = l1.next
        else:
            l3.next = l2
            l2 = l2.next
        l3 = l3.next
    
    l3.next = l1 if l1 else l2
    return sentinel.next


if len(lists) == 0:
    return None

last = len(lists) - 1

while last != 0:
    low, high = 0, last
    while low < high:
        lists[low] = merge_lists(lists[low], lists[high])
        low += 1
        high -= 1
    
    last = high

return lists[0]