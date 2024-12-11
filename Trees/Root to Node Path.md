```cpp
class Solution {
public:
    vector<int> ans;
    void helper(TreeNode* root, int target, std::vector<int>& path) {
        if (!root) {
            return;
        }
        path.push_back(root->val);

        if (root->val == target) {
            cout << "Path to node " << target << ": ";
            for (int val : path) {
                cout << val << " ";
            }
            cout << endl;
            ans = path;
            return;
        }
        helper(root->left, target, path);
        helper(root->right, target, path);

        path.pop_back();
    }

    vector<int>  getPath(TreeNode* root, int target) {
        vector<int> path;
        helper(root, target, path);
        return ans;
    }
};

```
