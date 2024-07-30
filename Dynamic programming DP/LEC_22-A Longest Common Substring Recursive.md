### Recursive  Solution for Longest Common Substring 
#### 1. MEMO + Top Down

LEETCODE LINK     https://leetcode.com/problems/maximum-length-of-repeated-subarray/
```cpp
class Solution {
public:
    int findLength(vector<int>& nums1, vector<int>& nums2) {
        return findLengthHelper(nums1, nums2, 0, 0, 0);
    }
    
private:
    int findLengthHelper(vector<int>& nums1, vector<int>& nums2, int i, int j, int count) {
        if (i == nums1.size() || j == nums2.size()) {
            return count;
        }
        
        int count1 = count;
        if (nums1[i] == nums2[j]) {
            count1 = findLengthHelper(nums1, nums2, i + 1, j + 1, count + 1);
        }
        
        int count2 = findLengthHelper(nums1, nums2, i + 1, j, 0);
        int count3 = findLengthHelper(nums1, nums2, i, j + 1, 0);
        
        return max({count, count1, count2, count3});
    }
};
```
