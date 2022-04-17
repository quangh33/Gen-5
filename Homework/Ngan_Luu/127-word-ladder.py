# 127. https://leetcode.com/problems/word-ladder/
def checkSameChar(word1, word2):
    count=0
    for i in range(len(word1)):
        if word1[i]!=word2[i]:
            count+=1
        if count==2:
            return False
    return True
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if beginWord in wordList:
            wordList.remove(beginWord)
        queue=[beginWord]
        distance=[1]
        visited={beginWord:True}
        while queue:
            word=queue[0]
            d=distance[0]
            queue.pop(0)
            distance.pop(0)
            for w in wordList:
                if w not in visited:
                    if checkSameChar(word,w):
                        if w==endWord:
                            return d+1
                        queue.append(w)
                        distance.append(d+1)
                        visited[w]='True'
        return 0