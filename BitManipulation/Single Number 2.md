**Problem Statement:**
Given an integer array `nums` where every element appears three times except for one, which appears exactly once. Find the single element and return it.

**Examples:**

**Example 1:**
Input: `nums = [2,2,3,2]`
Output: `3`

**Example 2:**
Input: `nums = [0,1,0,1,0,1,99]`
Output: `99`

**Approach:**
Start with `i=1`; move to `i= i+3` because the number appears exactly three times. If the current number is not equal to the previous one, then the previous number is the answer.

**Edge Case:**
There is an edge case if the single element appears at the end. For that, we just have to return `nums[nums.size()-1]` because it won't be found in the loop.

**Solution:**
```cpp
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        for(int i =1; i<nums.size(); i= i+3){
            if(nums[i] != nums[i-1]){
                return nums[i-1];
            }
        }
        return nums[nums.size()-1];
    }
};
```