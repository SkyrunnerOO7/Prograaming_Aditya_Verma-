**Intuition:**
The XOR of any two same integers is always zero. This means that if we XOR all the numbers in the array together, the numbers that appear twice will cancel each other out, leaving us with the single number that appears only once.

**Example:**
Let's consider the array `[4,1,2,1,2]`. If we XOR all the numbers together, we get:
```
4 ^ 1 ^ 2 ^ 1 ^ 2 = 4
```
As expected, the numbers that appear twice (1 and 2) cancel each other out, leaving us with the single number 4.

**Solution:**
Here's the C++ code that implements this idea:
```cpp
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int ans = nums[0];
        for(int i=1; i<nums.size(); i++){
            ans = ans ^ nums[i];
        }
        return ans;
    }
};
```
This solution iterates through the array, XORing each number with the current answer. At the end of the iteration, the answer will be the single number that appears only once in the array.