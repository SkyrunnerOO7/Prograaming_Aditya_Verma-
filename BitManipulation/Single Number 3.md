**Approach:**
Using two buckets, we first XOR all the integers. Then, numbers with frequency 2 will get eliminated, leaving us with only the XOR of the two numbers we want to return. Since these two numbers are different, their bits will be different at least at one place. We find the lowest changing bit using `y^(y&(y-1))` and then put all the numbers with that bit set to one in one bucket and not set in another bucket. All the pairs will be in the same buckets, but the numbers we want to return will be in different buckets.

**Step-by-Step Solution:**

1. Initialize a variable `y` to 0 and XOR all the integers in the array with `y`. This will eliminate numbers with frequency 2, leaving us with the XOR of the two numbers we want to return.
2. Find the lowest changing bit in `y` using `y^(y&(y-1))` and store it in `x`.
3. Initialize two variables `a` and `b` to 0. These will be used to store the two numbers we want to return.
4. Iterate through the array again. For each number, check if the bit at the position found in step 2 is set. If it is, XOR the number with `b`. If not, XOR the number with `a`.
5. After the iteration, `a` and `b` will hold the two numbers we want to return.

```cpp
class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        long long int y = 0;
        for(int i=0; i<nums.size(); i++){
            y = y^nums[i];
        }
        int x = y^(y&(y-1));
        int a=0, b=0;
        for(int i=0; i<nums.size(); i++){
            if(x&nums[i]){
                b= b^nums[i];
            }else{
                a= a^nums[i];
            }
        } 
        return {a,b};
    }
};
```