class Node:
    def __init__(self,key,val):
        self.key,self.val = key,val
        self.prev,self.next = None


class LRUCache:
    def __init__(self,capacity) -> None:
        self.cap = capacity
        self.left , self.right = Node(0,0),Node(0,0)
        self.cache = {}
    
    def remove(self,node):
        prev,next = node.prev,node.next
        prev.next,next.prev = next,prev
    
    def insert(self,node):
        prev,next = self.right.prev,self.right.next
        prev.next = next.prev = node
        node.prev,node.next = prev,next

    def get(self,key) -> int:
        if key in self.cache:
            self.remove(self.cache[key])
            self.insert(self.cache[key])
            return self.cache[key].val
        return -1

    def put(self,key,val):
        if key in self.cache:
            self.remove(self.cache[key])
        self.cache[key] = Node(key,val)
        self.insert(self.cache[key])

        if len(self.cache) > self.cap:
            lru = self.left.next
            self.remove(lru)
            del self.cache[lru.key]