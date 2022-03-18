var singleNumber = function (nums) {
  let single = null;
  for (let i = 0; i < nums.length; i++) {
    single = single ^ nums[i];
  }
  return single;
};
