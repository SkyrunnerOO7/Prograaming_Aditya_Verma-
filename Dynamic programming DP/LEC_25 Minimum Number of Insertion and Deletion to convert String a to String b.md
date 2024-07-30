LEETCODE QUESTION LINK : https://leetcode.com/problems/delete-operation-for-two-strings/submissions/
GFG QUESTION LINK : https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1

### STEPS -
  1/- CALCULATE LCS OF THE TWO STRINGS X AND Y
  
  2/- FOR NUMBER OF DELETION DO 
            LEN(X)-LCS = NUMBER OF DELETION
            
  3/- FOR NUMBER OF INSERTION DO 
            LEN(Y)-LCS = NUMBER OF INSERTION
            
  4/- FINALLY FOR Minimum number of deletions and insertions.
              RETURN (NUMBER OF DELETION + NUMBER OF INSERTION)

Note : n and m are inverse 
I usually do n then m

```java
class Solution {
    public int minDistance(String X, String Y) {
        
      //Your code here
        int m = X.length();
        int n = Y.length();
        int t[][] = new int[m+1][n+1];
        
        for(int i =0; i<=m; i++)
        {
            for(int j =0; j<=n; j++)
            {
                if(i==0||j==0)
                {
                    t[i][j] = 0;
                }
            }
        }
        
        for(int i =1; i<=m; i++)
        {
            for(int j =1; j<=n; j++)
            {
                if(X.charAt(i-1) == Y.charAt(j-1))
                {
                    t[i][j] = 1+t[i-1][j-1];
                }else
                {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        
        int deletion = m-t[m][n];
        int insertion = n-t[m][n];
        
        return deletion + insertion;
        
    }
}
```
