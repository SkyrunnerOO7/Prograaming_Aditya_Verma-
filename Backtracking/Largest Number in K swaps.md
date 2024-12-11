```cpp

class Solution
{
    public:
    void solve(string str, int k, int start, string & ans) {
        // Base cases
        if(k == 0 || start == str.size()) {
            return;
        }
        char maxi = *max_element(str.begin() + start, str.end());

        // Only proceed to swap if maxi is greater than the current start element
        for (int i = start + 1; i < str.size(); i++) {

            // controlled recursion only swap with the largest numbers 
            if (str[i] > str[start]  && str[i] == maxi) {
                swap(str[start], str[i]);
                ans = max(ans, str);

                // we fixed the first number and now is the turn of start+1 --> next number
                solve(str, k - 1, start + 1, ans);
                swap(str[start], str[i]); // Backtrack here
            }
        }
        
        // Call the function without making a swap to move to the next character
        solve(str, k, start + 1, ans);
    }

    // Function to find the largest number after k swaps.
    string findMaximumNum(string str, int k) {
       string ans = str;
       solve(str, k, 0, ans);
       return ans;
    }
};


```