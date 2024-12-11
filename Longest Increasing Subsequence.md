Here's a well-formatted and organized version of the explanation and code for finding the Longest Increasing Subsequence (LIS) using both the Dynamic Programming approach with sets and sorting, and without using a set.

---

# Longest Increasing Subsequence (LIS) - Dynamic Programming Approach

## Problem Description

Given an integer array `nums`, find the length of the longest strictly increasing subsequence.

## Intuition

To solve this problem, different approaches can be used. One approach involves using a set and array to create a new array for comparison. This method is based on the concept of the Longest Common Subsequence (LCS) but adapted to find the LIS.

### Why Use a Set?

- **Set for Uniqueness and Sorting:**
  - A set helps to ensure that the elements in the new array are unique and sorted in ascending order.
  - This sorted array can then be compared with the original array to find the LCS, which translates directly to the LIS.

- **Set Usage:**
  - A set ensures a strictly increasing sequence by removing duplicates. 
  - For finding an increasing subsequence that can include equal values, you would not use a set and would instead rely on sorting directly.

**Example:**
- **Input:** `nums = [7, 7, 7, 7, 7, 7, 7]`
- **Output:**
  - For a strictly increasing subsequence: `1` (only one unique element).
  - For a non-strictly increasing subsequence: `7` (length of the array).

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
### LIS BOTTOM UP :

```cpp
class Solution {
public:
    int lengthOfLIS(vector<int>& x) {
        int n = x.size();
        set<int> st(x.begin(), x.end());
        vector<int> y(st.begin(), st.end());
        int m = y.size();
        
        int t[n+1][m+1];
        
        for(int i=0; i<n+1; i++){
            for(int j =0; j<m+1; j++){
                if(i==0 || j==0){
                    t[i][j] =0;
                }
            }
        }
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(x[i-1] ==y[j-1]){
                    t[i][j] = 1+ t[i-1][j-1];
                }else{
                    t[i][j]  = max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        
        return t[n][m];
    }
};
```

### Using Set  Memoization


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

### Without Using Set (Just Sorting)
This one will give us the longest increasing subsequence but not strictly increasing, only increasing
```cpp
class Solution {
public:
    int lengthOfLIS(vector<int>& x) {
        int n = x.size();
        vector<int> y = x; 
        
        sort(y.begin(), y.end());
        int m = y.size();
        
        int t[n+1][m+1];
        
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(x[i-1] == y[j-1]) {
                    t[i][j] = 1 + t[i-1][j-1];
                } else {
                    t[i][j] = max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        
        return t[n][m];
    }
};
```
