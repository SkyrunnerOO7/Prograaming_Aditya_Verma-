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


### TOP Down Approach

```cpp
class Solution {
public:
    int findLength(vector<int>& nums1, vector<int>& nums2) {
        int n =nums1.size(), m = nums2.size();
        int t[n+1][m+1];
        
        for(int i =0; i<n+1; i++) t[i][0]=0;
        for(int j=0; j<m+1; j++) t[0][j]=0;
        
        int ans = 0;
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(nums1[i-1] == nums2[j-1]){
                    t[i][j]= 1+ t[i-1][j-1];
                    ans = max(ans, t[i][j]);
                }else{
                    t[i][j] =0;
                }
            }
        }
        
        return ans;
    }
};

```
