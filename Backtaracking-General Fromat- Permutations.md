## General Format for Backtracking

```cpp
solve(pass by reference) {
    base condition {
        // calculations can be here or not
        return;
    }
    
    // loop over choices
    // in backtracking we have a larger number of choices than recursion
    for(i in choices) {
        // do the changes in the values passed by reference
        solve(pass by reference, next);
        // undo the changes that you just did above
    }
}
```

In backtracking, we typically:
1. Check for the base condition
2. Loop over possible choices
3. Make changes
4. Recursively call the function
5. Undo the changes (backtrack)

## Specific Implementation: Permutations

Here's the specific implementation for generating all permutations of a given set of integers:

```cpp
class Solution {
public:
    void solve(int start, vector<int> &nums, vector<vector<int>> &ans) {
        if(start == nums.size() - 1) {
            ans.push_back(nums);
            return;
        }
        for(int i = start; i < nums.size(); i++) {
            swap(nums[start], nums[i]);
            solve(start + 1, nums, ans);
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

### How it works

1. The `permute` function initializes the process and returns the final result.
2. The `solve` function implements the backtracking algorithm:
   - Base case: When `start` reaches the last index, we've formed a complete permutation.
   - We iterate from `start` to the end of the array, swapping elements to create new permutations.
   - After each recursive call, we swap back (backtrack) to undo the change.


## Time and Space Complexity

- Time Complexity: O(n!), where n is the number of elements in the input array.
- Space Complexity: O(n) for the recursion stack.

## Note

This solution modifies the input array during the process but restores it to its original state before returning.That is what is Backtracking
```
