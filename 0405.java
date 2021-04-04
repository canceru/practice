给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。

返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。

class Solution {
    public String generateTheString(int n) {
        StringBuffer sb = new StringBuffer();
        if(n%2==0){
            for(int i= 1;i<n;i++){
                sb.append('a');
            }
            sb.append('b');
        }else{
            for(int i=1;i<=n;i++){
                sb.append('b');
            }
        }
        return sb.toString();
    }
}

给你一个字符串 s ，请你根据下面的算法重新构造字符串：

从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
重复步骤 2 ，直到你没法从 s 中选择字符。
从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
重复步骤 5 ，直到你没法从 s 中选择字符。
重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。

请你返回将 s 中字符重新排序后的 结果字符串 。
class Solution {
    public String sortString(String s) {
        int[] arr = new int[26];
        for(int i =0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;  
        }
        StringBuffer sb = new StringBuffer();
        while(sb.length()<s.length()){
            for(int i=0;i<arr.length;i++){
                if(arr[i]>0){
                    sb.append((char)(i+'a'));
                    arr[i]--;
                }
            }

            for(int i=arr.length-1;i>=0;i--){
                if(arr[i]>0){
                    sb.append((char)(i+'a'));
                    arr[i]--;
                }
            }
        }  
        return sb.toString();
    }
}
