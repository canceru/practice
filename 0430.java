输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n).
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==1){
            return array[0];
        }
        if(array.length==0){
            return 0;
        }
        int tmp = array[0];
        int[] dp = new int[array.length];
        dp[0]=array[0];
        for(int i=1;i<array.length;i++){
            int max=dp[i-1]+array[i];
            if(max>array[i]){
                dp[i]=max;
            }else{
                dp[i]=array[i];
            }
            if(dp[i]>tmp){
                tmp=dp[i];
            }
        }
        return tmp;
    }
}