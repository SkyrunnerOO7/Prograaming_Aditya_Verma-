# Path Sum in Binary Tree

This repository contains two implementations of the `hasPathSum` function, which checks whether there exists a root-to-leaf path in a binary tree where the sum of the node values equals a specified target sum.

## Function Descriptions

### 1. Implementation with Helper Function and Flag

```cpp
class TreeNode {
public:
    int val;
    TreeNode *left, *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    bool flag = false;

    void helper(TreeNode* root, int sum, int &currSum) {
        if (!root) {
            return;
        }

        currSum += root->val;

        if (!root->left && !root->right) {
            if (currSum == sum) {
                flag = true;
            }
        }
        helper(root->left, sum, currSum);
        helper(root->right, sum, currSum);

        currSum -= root->val;
    }

    bool hasPathSum(TreeNode* root, int sum) {
        int currSum = 0;
        helper(root, sum, currSum);
        return flag;
    }
};
```

**Description**: This implementation uses a recursive helper function to traverse the binary tree and checks if a path sum exists. It maintains a `flag` to indicate whether a valid path has been found.

### 2. Implementation Using Direct Recursion

```cpp
class TreeNode {
public:
    int val;
    TreeNode *left, *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    bool hasPathSum(TreeNode* root, int sum) {
        if (!root) {
            return false;
        }
        if (!root->left && !root->right) {
            return root->val == sum;
        }
        if(hasPathSum(root->left, sum - root->val) ||  hasPathSum(root->right, sum - root->val)){
            return true;
        }
        return false;
    }
};
```

**Description**: This implementation directly checks the conditions recursively without using a helper function. It simplifies the logic by returning the result of the checks immediately.

## Time Complexity

- **Both Implementations**:
  - **O(N)**: Each implementation visits every node in the tree exactly once, leading to linear time complexity, where \(N\) is the number of nodes in the binary tree.

## Space Complexity

- **Both Implementations**:
  - **O(H)**: The space complexity is determined by the height of the tree \(H\) due to the recursion stack. In the worst case (for example, a skewed tree), the maximum depth of the recursion can be equal to the height of the tree.
