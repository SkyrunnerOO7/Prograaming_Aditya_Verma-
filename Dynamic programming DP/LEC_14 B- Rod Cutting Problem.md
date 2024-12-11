```cpp
class Solution {
public:
    int cutRodRecursive(int price[], int length[], int n, int rodLength) {
        if (n == 0 || rodLength == 0) {
            return 0;
        }

        if (length[n - 1] <= rodLength) {
            return max(price[n - 1] + cutRodRecursive(price, length, n, rodLength - length[n - 1]),
                       cutRodRecursive(price, length, n - 1, rodLength));
        } else {
            return cutRodRecursive(price, length, n - 1, rodLength);
        }
    }

    int cutRod(int price[], int n) {
        vector<int> length(n);
        for (int i = 0; i < n; i++) {
            length[i] = i + 1;
        }
        return cutRodRecursive(price, length.data(), n, n);
    }
};


```
