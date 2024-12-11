![Image Description](../misc/recursive_tree_of_generate_paranthesis.png)

```cpp
class Solution {
public:
    // Function to generate balanced parenthesis
    void generateParenthesisUtil(int open, int close, string op, vector<string> &ans){
        // If there are no more open and close brackets, add the generated string to the answer
        if(open==0 && close ==0){
            ans.push_back(op);
            return;
        }
        // If there are still open brackets, add an open bracket and call the function recursively
        if(open){
            string op1 = op+ '(' ;
            generateParenthesisUtil(open-1, close, op1, ans);
        }
        // If there are more open brackets than close brackets, add a close bracket and call the function recursively
        if(open < close){
            string op2 = op + ')';
            generateParenthesisUtil(open, close-1, op2, ans);
        }
    }
    // Function to generate balanced parenthesis
    vector<string> generateParenthesis(int n) {
        vector<string> ans;
        int open = n,close = n;
        generateParenthesisUtil(open, close, "", ans);
        return ans;
    }
};
```