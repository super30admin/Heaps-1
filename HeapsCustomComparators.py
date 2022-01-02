# class FreqWord(object):
#     def __init__(self, freq, word):
#         self.freq = freq
#         self.word = word
        
#     def __lt__(self, other):
#         if self.freq != other.freq:
#             return lt(self.freq, other.freq)
#         else:
#             # opposite sort
#             return lt(other.word, self.word)

# class Solution:
#     def topKFrequent(self, words: List[str], k: int) -> List[str]:

#         words_with_count = collections.Counter(words)
            
#         min_heap = list()
#         for word, count in words_with_count.items():
#             heapq.heappush(min_heap, FreqWord(count, word))
#             if len(min_heap) > k:
#                 heapq.heappop(min_heap)
        
#         return [heapq.heappop(min_heap).word for _ in range(k)][::-1] 



# import required module
import heapq as hq

# class definition
class employee:

# constructor
	def __init__(self, n, yos):
		self.name = n
		self.yos = yos

# override the comparison operator
	def __lt__(self, nxt):
		return self.yos < nxt.yos # Min Heap
        # return self.yos > nxt.yos # Max Heap


minheap = []
# creating objects
e = {'Anish' : 3, 'kathy' : 2, 'Rina': 5 , 'Vinay': 1}

for key, val in e.items():
    hq.heappush(minheap, employee(key, val))
    if len(minheap) > 2:
        hq.heappop(minheap)


ans = [hq.heappop(minheap).name for _ in range(2)][::-1] 
print(ans)




