QUESTION LINK: https://leetcode.com/problems/is-subsequence/submissions/
```
STEP - 
  1/- CALCULATE LCS B/W S1 AND S2
  2/- IF LCS ANSWER (t[n][m]) EQUALS TO LENGTH OF S1 
          -- RETURN TRUE
          -- ELSE FALSE
```

```java
class Solution {
    public boolean isSubsequence(String s1, String s2) {
        
        int n = s1.length();
        int m = s2.length();
        
        if(n == 0){return true;}
        
        int t[][] = new int[n+1][m+1];
        
        for(int i =1; i<=n; i++)
        {
            for(int j = 1; j<=m; j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    t[i][j] = 1+t[i-1][j-1];
                }else
                {
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }
        
        if(n == t[n][m]){return true;}
        
        return false;
        
    }
}
```

Recusrive Solution for isSubSequence
```cpp
class Solution {
public:
    int lcs(string x, string y, int n, int m, vector<vector<int> > &dp){
        if(n==0|| m==0){
            return 0;
        }
        
        if(dp[n-1][m-1] != -1){
            return dp[n-1][m-1];
        }
        
        if(x[n-1] == y[m-1]){
            return dp[n-1][m-1] = 1+ lcs(x,y,n-1,m-1,dp);
        }
        
        return dp[n-1][m-1] = max(lcs(x,y,n,m-1,dp) , lcs(x,y,n-1,m,dp) );
    }
    bool isSubsequence(string s, string t) {
        vector<vector<int> > dp(s.size(), vector<int> (t.size(),-1 ) );
        
        int x= lcs(s, t, s.size(), t.size(), dp);
        
        return x==s.size();
    }
};

```
