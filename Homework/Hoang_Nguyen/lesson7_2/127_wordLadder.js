var buildGraph = function (beginWord, wordList) {
  const m = beginWord.length;

  // map: wildcard -> set of words
  const wildcards = new Map();

  function getWildcard(word, i) {
    return word.slice(0, i) + '*' + word.slice(i + 1);
  }

  function addToWildcards(word) {
    for (let i = 0; i < m; i++) {
      const wildcard = getWildcard(word, i);
      if (!wildcards.has(wildcard)) {
        wildcards.set(wildcard, new Set());
      }
      wildcards.get(wildcard).add(word);
    }
  }

  // build wildcards
  addToWildcards(beginWord);
  for (let i = 0; i < wordList.length; i++) {
    addToWildcards(wordList[i]);
  }
  // console.log(wildcards)

  // build graph
  // map: word -> set of connected words
  const graph = new Map();

  function addToGraph(word) {
    for (let i = 0; i < m; i++) {
      const wildcard = getWildcard(word, i);
      const connectedWords = wildcards.get(wildcard);
      for (const connectedWord of connectedWords) {
        if (!graph.has(word)) {
          graph.set(word, new Set());
        }
        graph.get(word).add(connectedWord);
      }
    }
  }

  addToGraph(beginWord);
  for (let i = 0; i < wordList.length; i++) {
    addToGraph(wordList[i]);
  }

  return graph;
};

/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function (beginWord, endWord, wordList) {
  const graph = buildGraph(beginWord, wordList);
  // console.log(graph)

  const visited = new Set();

  const queue = [];

  visited.add(beginWord);
  for (const word of graph.get(beginWord)) {
    visited.add(word);
    queue.unshift(word);
  }

  let currentDis = 1;
  while (queue.length) {
    currentDis++;
    const currentSize = queue.length;
    for (let i = 0; i < currentSize; i++) {
      const word = queue.pop();
      if (word === endWord) {
        return currentDis;
      }
      for (const nextWord of graph.get(word)) {
        if (!visited.has(nextWord)) {
          visited.add(nextWord);
          queue.unshift(nextWord);
        }
      }
    }
  }
  return 0;
};
