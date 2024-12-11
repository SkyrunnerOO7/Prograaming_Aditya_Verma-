### Anagram 
Frequency same and size same and in continuous subarray

```cpp
class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        map<int,int> mp;
        for(int i=0; i<p.size(); i++){
            mp[p[i]]++;
        }
        int i=0,j=0;
        vector<int> ans;
        int count = mp.size();
        while( j <s.size() ){
            if(mp.find(s[j]) != mp.end()){
                mp[s[j]]--;
                if(mp[s[j]] ==0){
                    count--;
                }
            }
            if(j-i+1 < p.size()){
                j++;
            }else if(j-i+1 == p.size()){
                if(count ==0){
                    ans.push_back(i);
                }
                if(mp.find(s[i]) != mp.end()){
                    mp[s[i]]++;
                    if(mp[s[i]]==1){
                        count++;
                    }
                }
                i++;
                j++;
            }
        }
        
        return ans;
    }
};

```
