```cpp

class Solution {
public:
    void solve(vector<int> nums, vector<int> op, vector<vector<int>> &ans, map<vector<int>,int> &mp){
        if(nums.size()==0){
            if(mp.find(op)==mp.end()){
                ans.push_back(op);
                mp[op]++;
            }
            return;
        }
        vector<int> op1 = op;
        vector<int> op2 = op;
        op1.push_back(nums[0]);
        
        nums.erase(nums.begin());
        solve(nums,op1,ans,mp);
        solve(nums,op2,ans,mp);
    }
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int> > ans;
        map<vector<int>,int> mp;
        sort(nums.begin(),nums.end());
        solve(nums,{},ans,mp);
        return ans;
    }
};

```