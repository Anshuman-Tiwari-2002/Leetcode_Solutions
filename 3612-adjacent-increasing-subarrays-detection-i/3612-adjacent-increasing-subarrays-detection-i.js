/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var hasIncreasingSubarrays = function(nums, k) {
    let increaseCount = 1, prev = 0;

    for(let i=1; i<=nums.length; i++) {
        if(nums[i-1]< nums[i])
        increaseCount++;
        else{
            prev = increaseCount;
            increaseCount = 1;
        }
        if(Math.floor(increaseCount / 2) >= k || Math.floor(prev / 2) >=    k || Math.min(prev, increaseCount) >= k)
        return true;
    }
    return false;
};