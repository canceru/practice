编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         if (strs == null || strs.length == 0) {
//             return "";
//         }
//         for(int i=0;i<strs[0].length();i++){
//             for(int j=1;j<strs.length;j++){
//                 if((i==strs[j].length()) || strs[0].charAt(i) !=strs[j].charAt(i)){
//                     return strs[0].substring(0,i);
//                 }
//             }
//         }
//         return strs[0];
//     }
// }

class Solution{
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
             return "";
        }
        String tmp=strs[0];
        for(int i=1;i<strs.length;i++){
            tmp=aaa(tmp,strs[i]);
        }
        return tmp;
    }


    public String aaa(String str1,String str2){
        int length = Math.min(str1.length(),str2.length());
        int i=0;
        for(;i<length;i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                break;
            }
        }
        return str1.substring(0,i);
    }

}

给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。

所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
class Solution {
    public String defangIPaddr(String address) {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<address.length();i++){
            if(address.charAt(i)=='.'){
                sb.append("[.]");
            }else{
                sb.append(address.charAt(i));
            }
        }
        return sb.toString();
    }
}