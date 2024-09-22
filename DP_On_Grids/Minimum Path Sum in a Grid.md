
```cpp

class Solution {
public:
    int solve(vector<vector<int>>& grid, int m, int n) {
        if(m==0 && n==0) return grid[0][0];
        if(m<0 || n<0) return INT_MAX -1 ;
        int up=solve(grid, m-1, n);
        int left=solve(grid, m, n-1);
        return grid[m][n] + min(left, up);
    }
    int minPathSum(vector<vector<int>>& grid) {
        int m=grid.size();
        int n=grid[0].size();
        return solve(grid, m-1, n-1);
    }
};

```
```cpp
class Solution {
public:

    int minPathSum(vector<vector<int>>& grid) {
        int n = grid.size(), m= grid[0].size();
        int t[n+1][m+1];
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<m+1; j++){
                if(i==0 || j==0){
                    t[i][j]=INT_MAX-1;
                }
            }
        }
        t[1][1]= grid[0][0];
        
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++){
                if(i==1 && j==1) continue;
                t[i][j] = grid[i-1][j-1] + min(t[i-1][j] , t[i][j-1]);
            }
        }
        return t[n][m];
    }
};
```
