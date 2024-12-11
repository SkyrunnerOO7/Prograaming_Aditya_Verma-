```cpp
class Solution {
public:
    void solve(int start, vector<int> &nums, vector<vector<int> > &ans){
        if(start== nums.size()-1){
            ans.push_back(nums);
            return;
        }
        for(int i = start; i<nums.size(); i++){
            swap(nums[start], nums[i]);
            solve(start+1, nums, ans);
            swap(nums[start], nums[i]);
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        solve(0, nums, ans);
        return ans;
    }
};


```
