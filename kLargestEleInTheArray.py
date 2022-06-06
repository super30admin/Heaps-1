'''
Time Complexity : 0(n * logk), iterate n elements; heapify on 'k' size list
Space Complexity : 0(k) --> maintain heapList of size k
'''

class minHeap:
    
    def __init__(self):
        self.heapList = []
    
    def insert(self,val):
        
        # base-case
        if len(self.heapList) == 0:
            # simply append!
            self.heapList.append(val)
            return self.heapList
        
        # logic-case
        # 1. append into the heapList
        self.heapList.append(val)
        
        # 2. create rfr to currentPtr
        currentPtr = len(self.heapList)-1
        
        # 3. create rfr to the parrentPtr
        parentPtr = (currentPtr-1)//2
        
        # 4. check for breech if any!
        self.bubbleUp(currentPtr,parentPtr)
        
        return self.heapList
    
    def bubbleUp(self,currentPtr,parentPtr):
        
        # base-condition
        if parentPtr < 0:
            # out of bounds
            return
        
        # logic-condition
        if self.heapList[currentPtr] < self.heapList[parentPtr]:
            # I have a breech
            
            # 1. swap the values
            self.heapList[currentPtr], self.heapList[parentPtr] = self.heapList[parentPtr], self.heapList[currentPtr]
            
            # 2. update the ptr rfr
            currentPtr = parentPtr
            parentPtr = (currentPtr-1)//2
            
            # 3. do recursive call
            self.bubbleUp(currentPtr,parentPtr)
        
        else:
            # Everything in OK
            return
    
    def extractMin(self):
        # deletes the root i.e. the minimum
        
        # 1. swap the "zeroIndex" value with the "lastIndex" value
        self.heapList[0], self.heapList[len(self.heapList)-1] = self.heapList[len(self.heapList)-1], self.heapList[0]
        
        # 2. remove the "lastIndex" value
        self.heapList.pop()
        
        # 3. bubbleDown
        self.bubbleDown(0)
        
        # 4. return the updated list
        return self.heapList
    
    def bubbleDown(self,parent):
        # base-case
        if parent == len(self.heapList)-1:
            # parentIndex at lastIndex
            return
        
        if (2*parent+1) > len(self.heapList)-1:
            # out of bounds
            return
        
        # logic-case
        # 1. get the child
        smallIndex = 2*parent+1
        
        # 1.1. if we have 2 children, get the smallIndex from the either 2
        if (2*parent+2) < len(self.heapList) and (self.heapList[smallIndex] > self.heapList[2*parent+2]):
            smallIndex = 2*parent+2
            
        # 2. compare with parent
        if self.heapList[parent] > self.heapList[smallIndex]:
            # swap parentVal with smallIndex val
            self.heapList[parent], self.heapList[smallIndex] = self.heapList[smallIndex], self.heapList[parent]
            # update parent
            parent = smallIndex
            # recursive call
            self.bubbleDown(parent)
        else:
            # it's ok
            return
        
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        '''Approach: 
           1. Find the "largest" ele; therefore maintain minHeap
           2. Maintain minHeap of size "k"
        '''
        
        # 1. create an obj of minHeap
        min_heap = minHeap()
        
        # 2. iterate the nums
        # maintain threshold count
        count = 0
        
        for num in nums:
            # 2.1 append the num into min_heap
            min_heap.insert(num)
            count+=1
            
            # 2.2 chk the threshold 
            if count > k:
                # extract min
                min_heap.extractMin()
                # update count 
                count -= 1
        
        # 3. return the num
        # kth largest ele will be my zeroth index
        # print('K: '+str(k)+' largest element is: ', min_heap.heapList[0])
        return min_heap.heapList[0]