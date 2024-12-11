```cpp

class Solution {
public:
    void solve(int n, string &str, vector<int> &ans) {
        if (n == 0) {
            if (!str.empty()) {
                int num = stoi(str);
                ans.push_back(num);
            }
            return;
        }
        
        char lastDigit = str.empty() ? '0' : str.back();
        for (int i =  1; i <= 9; i++) {
            if (str.size() ==0 || i > lastDigit - '0') {
                str += to_string(i);
                solve(n-1, str, ans);
                str.pop_back();
            }
        }
    }
    
    vector<int> increasingNumbers(int n) {
        vector<int> ans;
        string str = "";
        if (n==1){
            for(int i =0; i<10; i++){
            ans.push_back(i);
            }
            return ans;
        }
        
        solve(n, str, ans);
        return ans;
    }
};



```