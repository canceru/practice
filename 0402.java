// class Solution {
//     public String compressString(String S) {
//         StringBuffer sb = new StringBuffer();
//         int i=0;
//         while(i<S.length()){
//             int j=i;
//             while(j<S.length() && S.charAt(i)==S.charAt(j)){
//                     j++;
//             }
//             sb.append(S.charAt(i));
//             sb.append(j - i);
//             i = j;
//         }
//         return sb.length()>=S.length() ? S : sb.toString();
//     }
// }


class Solution {
    public String compressString(String S) {
        if (S.length() == 0) { // 空串处理
            return S;
        }
        StringBuffer ans = new StringBuffer();
        int cnt = 1;
        char ch = S.charAt(0);
        for (int i = 1; i < S.length(); ++i) {
            if (ch == S.charAt(i)) {
                cnt++;
            } else {
                ans.append(ch);
                ans.append(cnt);
                ch = S.charAt(i);
                cnt = 1;
            }
        }
        ans.append(ch);
        ans.append(cnt);
        return ans.length() >= S.length() ? S : ans.toString();
    }
}

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n=s.length();
        for(int i=1;i<=n/2;i++){
            if(n%i==0){
                boolean flag=true;
                for(int j=i;j<n;j++){
                    if(s.charAt(j)!=s.charAt(j-i)){
                        flag = false;
                        break;
                    }

                }
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }
}