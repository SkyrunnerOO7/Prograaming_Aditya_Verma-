GFG QUESTION LINK : https://practice.geeksforgeeks.org/problems/form-a-palindrome1455/1

Similar to the number of deletions to make a string palindrome.
STEPS-
  1/- CREAT A SECOND STRING S2 WHICH IS THE REVERSE OF THE STRING S
  2/- CALCULATE LCS B/W THE TWO STRINGS S AND S2
  3/- SUBTRACT LCS WITH THE LENGTH OF THE STRING
              LENGHT(s) - LCS

class Solution {
    public int minInsertions(String s) {
        
        //REVERSE OF STRING s
        String s2 = "";
        int len = s.length();
        
        for(int i =len-1; i>=0; i--)
        {
            s2 += String.valueOf(s.charAt(i));
        }
        
        int t[][] = new int[len+1][len+1];
        
        for(int i = 0; i<len+1; i++)
        {
            for(int j = 0; j<len+1; j++)
            {
                if(i==0||j==0)
                {
                    t[i][j] = 0;
                }
            }
        }
        
        
        for(int i = 1; i<len+1; i++)
        {
            for(int j = 1; j<len+1; j++)
            {
                if(s.charAt(i-1) == s2.charAt(j-1))
                {
                    t[i][j] = 1+t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }
        
        return len-t[len][len];
    }
}
