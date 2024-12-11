```cpp

class Solution {
public:
    void solve(vector<int> nums, vector<vector<int>>& ans, vector<int> op) {
        // Base case: if nums is empty, add the current subset to ans and return
        if(nums.size() == 0) {
            ans.push_back(op);
            return;
        }

        // Create two copies of the current subset
        vector<int> op1 = op;  // Option without including nums[0]
        vector<int> op2 = op;  // Option with including nums[0]

        op2.push_back(nums[0]); // Add the first element to op2

        // Erase the first element from nums for the next recursive call
        nums.erase(nums.begin());

        // Recur for both possibilities: including and not including the current element
        solve(nums, ans, op1); // Without current element
        solve(nums, ans, op2); // With current element
    }

    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans; // This will store all the subsets
        vector<int> op;          // Current subset being formed

        solve(nums, ans, op); // Start the recursion with an empty subset

        return ans; // Return the list of all subsets
    }
};


```