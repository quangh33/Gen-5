/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
  let result=[]
  let map ={
    ')':'(',
    ']':'[',
    '}':'{'
  }
  for(let i=0;i<s.length;i++){
    let item=s[i]
    if(map[item]===undefined)
      result.push(item)
    else{
      if(map[item]===result[result.length-1])result.pop()
      else return false
    }
  }
  return (!result.length)
};