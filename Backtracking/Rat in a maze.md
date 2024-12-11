```cpp

#include <vector>
#include <string>

using namespace std;

class Solution {
private:
    vector<pair<int, int>> dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    char arr[4] = {'L', 'U', 'R', 'D'};

    void getPaths(int x, int y, string &path, vector<vector<int>> &matrix, int n, vector<vector<bool>> &visited, vector<string> &paths) {
        // Base Condition:
        if (x == n - 1 && y == n - 1) {
            paths.push_back(path);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nrow = x + dir[i].first;
            int ncol = y + dir[i].second;
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && matrix[nrow][ncol] && !visited[nrow][ncol]) {
                path += arr[i];
                visited[nrow][ncol] = true;
                getPaths(nrow, ncol, path, matrix, n, visited, paths);
                path.pop_back();
                visited[nrow][ncol] = false;
            }
        }
    }

public:
    vector<string> findPath(vector<vector<int>> &m, int n) {
        string path = "";
        vector<string> paths;
        vector<vector<bool>> visited(n, vector<bool>(n, false));

        if (m[0][0] == 1) {
            visited[0][0] = true;
            getPaths(0, 0, path, m, n, visited, paths);
        }

        return paths;
    }
};


```