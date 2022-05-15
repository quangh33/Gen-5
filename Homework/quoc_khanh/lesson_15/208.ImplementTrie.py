EMPTY = ''

class TrieNode:
    def __init__(self) -> None:
        self.endAt = [False] * 26
        self.posts = [None] * 26

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        currNode = self.root
        index = -1
        length = len(word)
        for letterIdx, letter in enumerate(word):
            index = ord(letter) - 97
            if currNode.posts[index] == None:
                currNode.posts[index] = TrieNode()
            if letterIdx == length - 1:
                currNode.endAt[index] = True
            currNode = currNode.posts[index]

    def search(self, word: str) -> bool:
        currNode = self.root
        index = -1
        length = len(word)
        for letterIdx, letter in enumerate(word):
            index = ord(letter) - 97
            if currNode.posts[index] == None:
                return False
            if letterIdx == length - 1:
                break
            currNode = currNode.posts[index]
        return currNode.endAt[index]


    def startsWith(self, prefix: str) -> bool:
        currNode = self.root
        for letter in prefix:
            index = ord(letter) - 97
            if currNode.posts[index] == None:
                return False
            currNode = currNode.posts[index]
        return True
        


# Your Trie object will be instantiated and called as such:
obj = Trie()
obj.insert("apple")
print(obj.search("apple") == True)
print(obj.search("app") == False)
print(obj.startsWith("app") == True)
obj.insert("app")
obj.insert("apply")
print(obj.search("app") == True)
print(obj.search("apply") == True)