from queue import Queue
import string
from typing import List

def differByALetter(word1: str, word2: str) -> bool:
    if len(word1) != len(word2):
        return False
    count = 0
    length = len(word1)
    for i in range(length):
        if word1[i] != word2[i]:
            count += 1
    return count == 1

def buildAdjacentList(wordList: List[str]) -> map:
    wordSet = set(wordList)
    wordToWords = {}
    for word in wordList:
        for c in string.ascii_lowercase:
            for i in range(len(word)):
                newWord = word[:i] + c + word[i+1:]
                if newWord in wordSet:
                    if newWord in wordToWords:
                        wordToWords[newWord].append(word)
                    else:
                        wordToWords[newWord] = [word]
                    if word in wordToWords:
                        wordToWords[word].append(newWord)
                    else:
                        wordToWords[word] = [newWord]

    return wordToWords

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        visisted = {beginWord: True}
        wordToWords = buildAdjacentList(wordList)
        queue = Queue()
        for key in wordToWords.keys():
            if differByALetter(key, beginWord):
                queue.put((key, 2))
                visisted[key] = True
        while not queue.empty():
            levelLength = queue.qsize()
            for _ in range(levelLength):
                word, length = queue.get()
                if word == endWord:
                    return length
                nextWords = wordToWords.get(word, [])
                for w in nextWords:
                    if not visisted.get(w, False):
                        visisted[w] = True
                        queue.put((w, length + 1))
        return 0

s = Solution()
print(s.ladderLength("hit", "cog", ["hot","dot","dog","lot","log","cog"]) == 5)
print(s.ladderLength("hit", "cog",["hot","dot","dog","lot","log"]) == 0)
print(s.ladderLength("leet","code",["lest","leet","lose","code","lode","robe","lost"]) == 6)