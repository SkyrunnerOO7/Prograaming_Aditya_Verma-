```cpp
class Solution {
public:
    int solve(int i,int j,vector<vector<int>>& obstacleGrid,vector<vector<int>>& dp){
        if(i<0 || j<0)
            return 0;
        
        if(obstacleGrid[i][j]==1)
            return 0;

        if(i==0 && j==0)
            return 1;
        
        if(dp[i][j]!=-1)
            return dp[i][j];

        int up=solve(i-1,j,obstacleGrid,dp);
        int left=solve(i,j-1,obstacleGrid,dp);
        
        return dp[i][j]=left+up;
    }
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m=obstacleGrid.size();
        int n=obstacleGrid[0].size();
        vector <vector<int>> dp(m,vector<int> (n,-1));
        return solve(m-1,n-1,obstacleGrid,dp);
    }
};

```


```cpp
class Solution {
public:
    
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int n = obstacleGrid.size(), m= obstacleGrid[0].size();
        int t[n + 1][m + 1];
    
        for (int i=0; i< n+1; i++) {
            for (int j = 0; j< m+1; j++) {
                t[i][j] = 0;
            }
        }
        t[1][1] = 1;
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if(obstacleGrid[i-1][j-1] ==1) {
                    t[i][j] =0;
                }else{
                    if (i == 1 && j == 1) continue; 
                    t[i][j] = t[i][j - 1] + t[i - 1][j];
                    
                }
                    
            }
        }
        
        return t[n][m];   
    }
};


````