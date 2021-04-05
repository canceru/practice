给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
class Solution {
    public String reverseOnlyLetters(String S) {
        int i =0;
        int j =S.length()-1;
        char[] arr = S.toCharArray();
        while(i<j){
            while(i<j && (!Character.isLetter(arr[i]))){
                i++;
            }
            while(j>i&&(!Character.isLetter(arr[j]))){
                j--;
            }
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
        return new String(arr);
    }
}