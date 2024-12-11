```cpp
class Solution {
public:
    void solve(int start, vector<vector<int>>& ans, vector<int>& nums) {
        if (start == nums.size()) {
            ans.push_back(nums);
            return;
        }
        unordered_set<int> used;
        for (int i = start; i < nums.size(); i++) {
            if (used.find(nums[i]) == used.end()) {
                used.insert(nums[i]);
                swap(nums[start], nums[i]);
                solve(start + 1, ans, nums);
                swap(nums[start], nums[i]);
            }
        }
    }
    
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> ans;
        solve(0, ans, nums);
        return ans;
    }
};

```
