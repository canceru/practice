现在有五张扑克牌，我们需要来判断一下是不是顺子。
有如下规则：
A为1,J为11,Q为12,K为13
数据中的0可以看作任意牌
如果给出的五张牌能组成顺子（即这五张牌是连续的）就输出true，否则就输出false。
例如：给出数据[6,0,2,0,4]
中间的两个0一个看作3，一个看作5 。即：[6,3,2,5,4]
这样这五张牌在[2,6]区间连续，输出true
数据保证每组5个数字，每组最多含有4个零

import java.util.*;
public class Solution {
    public boolean IsContinuous(int [] numbers) {
//         Arrays.sort(numbers);
//         int tmp=0;
//         for(int i=0;i<4;i++){
//             if(numbers[i]==0){
//                 tmp++;
//             }else if(numbers[i]==numbers[i+1]){
//                 return false;
//             }
//         }
//         return numbers[4]-numbers[tmp]<5;
        
        int max=0;
        int min=14;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==0){
                continue;
            }
            max=Math.max(numbers[i],max);
            min=Math.min(numbers[i],min);
            if(set.contains(numbers[i]))
                return false;
            set.add(numbers[i]);
        }
        return max-min<5;
    }
}