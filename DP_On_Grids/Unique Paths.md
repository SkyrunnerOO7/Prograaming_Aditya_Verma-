```cpp
class Solution {
public:
    int f(int m, int n, int i, int j, vector<vector<int>>& dp){
        if(i==m-1 and j==n-1) return 1;
        if(i>=m or j>=n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int down = f(m, n, i+1, j, dp);
        int right = f(m, n, i, j+1, dp);
        dp[i][j] = down + right;
        return dp[i][j];
    }
    
    int uniquePaths(int m, int n) {
        vector<vector<int>> dp(m, vector<int>(n, -1));
        return f(m, n, 0, 0, dp);
    }
};
```

```cpp
class Solution {
public:
    int uniquePaths(int m, int n) {
        int t[n+1][m+1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                t[i][j] = 0;
            }
        }
        t[1][1] = 1;
        
        for (int i= 1; i < n + 1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (i==1 && j==1) continue; 
                t[i][j] = t[i][j-1] + t[i-1][j];
            }
        }
        
        return t[n][m];
    }
};
