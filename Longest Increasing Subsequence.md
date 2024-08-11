# Longest Increasing Subsequence (LIS) - Dynamic Programming Approach

## Problem Description

Given an integer array `nums`, find the length of the longest strictly increasing subsequence.

## Intuition


I used set and array to make new array because in lcs we have to need 2 array, and i used set because set stores unique element in ascending order and then it store in array.

### Why Use a Set?

- **Set for Uniqueness and Sorting:** 
  - By using a set, we ensure that the elements in the new array are unique and sorted in ascending order.
  - This sorted array can then be compared with the original array to find the LCS, which directly translates to the LIS.

## Approach

I make sorted and increasing array because if we take lcs of old and newarray then it give longest increasing subsequence

## Complexity

- **Time Complexity**: `O(n * m)`
  - Where `n` is the size of the original array, and `m` is the size of the sorted, unique array.
  
- **Space Complexity**: `O(n * m)`
  - Due to the storage requirements for the DP array.

## Code

```cpp
class Solution {
public:
    int dp[2501][2501];

    int solve(vector<int>& old, vector<int>& newarray, int n, int m) {
        if (n <= 0 || m <= 0)
            return 0;
        if (dp[n][m] != -1)
            return dp[n][m];
        if (old[n-1] == newarray[m-1])
            return dp[n][m] = 1 + solve(old, newarray, n-1, m-1);
        else {
            return dp[n][m] = max(solve(old, newarray, n-1, m), solve(old, newarray, n, m-1));
        }  
    }

    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        set<int> st(nums.begin(), nums.end());
        vector<int> v(st.begin(), st.end());
        int m = v.size();
        memset(dp, -1, sizeof(dp));
        return solve(nums, v, n, m);
    }
};
```
