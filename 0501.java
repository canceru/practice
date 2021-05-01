输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数
例如，1~13中包含1的数字有1、10、11、12、13因此共出现6次
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        return f(n);
    }
    
    public int f(int n ) {
        if (n <= 0)
            return 0;
        String s = String.valueOf(n);
        int high = s.charAt(0) - '0';
        int pow = (int) Math.pow(10, s.length()-1);
        int last = n - high*pow;
        if (high == 1) {
            return f(pow-1) + last + 1 + f(last);
        } else {
            return pow + high*f(pow-1) + f(last);
        }
    }
}
