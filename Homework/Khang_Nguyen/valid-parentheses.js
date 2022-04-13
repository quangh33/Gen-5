// O(n) time, O(1) space
var isValid = function(s) {
  const len = s.length
  if (len < 2) return false

  if (isClose(s[0])) return false

  let openIndex = 0
  while (openIndex < s.length - 1) {
      if (isOpen(s[openIndex+1])) {
          openIndex++
      } else {
          if (!isPair(s[openIndex] + s[openIndex + 1])) return false
          s = s.slice(0, openIndex).concat(s.slice(openIndex + 2))
          openIndex--
      }
  }
  return s.length < 1
};
function isOpen(c){
    return "[{(".includes(c)
} 
function isClose(c){
    return ")]}".includes(c)
} 
function isPair(c) {
    return "()[]{}".includes(c)
}