# Longest Increasing Subsequence (LIS) - Dynamic Programming Approach

## Problem Description

Given an integer array `nums`, find the length of the longest strictly increasing subsequence.

## Intuition

To solve this problem, I used a set and array to create a new array because, in the Longest Common Subsequence (LCS) problem, we need two arrays. A set is used to store unique elements in ascending order, which can then be used to compare with the original array to find the LCS. This approach directly translates to finding the LIS.

### Why Use a Set?

- **Set for Uniqueness and Sorting:**
  - By using a set, we ensure that the elements in the new array are unique and sorted in ascending order.
  - This sorted array can then be compared with the original array to find the LCS, which directly translates to the LIS.

- **Set Usage:**
  - The set is used to ensure that we get a strictly increasing subsequence. For a strictly increasing sequence, duplicates are not allowed. 
  - For an increasing subsequence that can have equal values ( duplicates ), we would not use a set and would rely on sorting directly.

**Example:**
- **Input:** `nums = [7, 7, 7, 7, 7, 7, 7]`
- **Output:** `1` or `7`

  For a strictly increasing sequence, the output is `1` (as only one element is allowed). If duplicates are considered for non-strictly increasing sequences, the output would be `7` (using sorting without a set).

## Approach

1. **Create a Sorted and Unique Array:**
   - Use a set to get unique values from the original array, which automatically sorts them.
   - Convert this set back to an array.

2. **Compute LCS:**
   - Find the Longest Common Subsequence (LCS) between the original array and the sorted, unique array.
   - The length of this LCS is the length of the Longest Increasing Subsequence (LIS).

## Complexity

- **Time Complexity:** `O(n * m)`
  - Where `n` is the size of the original array, and `m` is the size of the sorted, unique array.

- **Space Complexity:** `O(n * m)`
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
