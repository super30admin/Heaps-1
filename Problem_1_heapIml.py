# // Time Complexity : O(n log k)
# // Space Complexity : O(k)
    
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = Heap()

        for num in nums:
            heap.push(num)
            if len(heap.heap) > k:
                heap.pop()
        
        return heap.pop()


class Heap:
    def __init__(self):
        self.heap = []

    def push(self, num):
        self.heap.append(num)
        i = len(self.heap) - 1
        while i > 0:
            parent = (i - 1) // 2
            if self.heap[i] < self.heap[parent]:
                self.heap[i], self.heap[parent] = self.heap[parent], self.heap[i]
                i = parent
            else:
                break
      
                 
    def pop(self):
        
        self.heap[-1],self.heap[0] = self.heap[0],self.heap[-1]
        smallest = self.heap.pop(-1)
        parentIdx = 0 

        for i in range(len(self.heap)):
            child1 = 2*parentIdx+1
            child2 = 2*parentIdx+2
            
            if(child1 < len(self.heap) and child2 < len(self.heap)):
                if(self.heap[child1]<=self.heap[child2]):
                    if(self.heap[child1] < self.heap[parentIdx]):
                        self.heap[child1],self.heap[parentIdx] = self.heap[parentIdx],self.heap[child1]
                        parentIdx = child1
                    else:
                        break
                else:
                    if(self.heap[child2] < self.heap[parentIdx]):
                        self.heap[child2],self.heap[parentIdx] = self.heap[parentIdx],self.heap[child2]
                        parentIdx = child2
                    else:
                        break        
            elif(child1 < len(self.heap)):
                if(self.heap[child1] < self.heap[parentIdx]):
                        self.heap[child1],self.heap[parentIdx] = self.heap[parentIdx],self.heap[child1]
                        parentIdx = child1
                else:
                    break
            elif(child2 < len(self.heap)):
                if(self.heap[child2] < self.heap[parentIdx]):
                        self.heap[child2],self.heap[parentIdx] = self.heap[parentIdx],self.heap[child2]
                        parentIdx = child2
                else:
                    break        

        return(smallest)


        


        
        