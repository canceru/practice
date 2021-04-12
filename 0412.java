把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int i = 0;
        int j = array.length-1;
        while(i<j){
            int mid =(i+j)/2;
            if(array[j]<array[mid]){
                i=mid+1;
            }else if(array[j]>array[mid]){
                j=mid;
            }else{
                j--;
            }
        }
        return array[i];
    }
}


用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 =new Stack<>();
    Stack<Integer> stack2=new Stack<>();
    public void push(int node){
        stack1.push(node);
    }
    
    public int pop(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

