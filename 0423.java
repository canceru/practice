定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
import java.util.Stack;

public class Solution {

    Stack<Integer> stack1=new Stack();
    Stack<Integer> stack2=new Stack();
    public void push(int node) {
        
        stack1.push(node);
        if(stack2.isEmpty()){
            stack2.push(node);
        }else{
            if(node<stack2.peek()){
                stack2.push(node);
            }else{
                stack2.push(stack2.peek());
            }
        }
        
        
        
    }
    
    public void pop() {
        stack1.pop();
        stack2.pop();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int min() {
        return stack2.peek();
    }
}

输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。（ps：我们约定空树不是二叉搜素树）
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)return false;
        return bbbb(sequence,0,sequence.length-1);
    }
    
    public boolean bbbb(int[] seq,int left,int right){
        if(left>right){
            return true;
        }
        int i=left;
        for(;i<right;i++){
            if(seq[i]>seq[right]){
                break;
            }
        }
        
        for(int j=i;j<right;j++){
            if(seq[j]<seq[right]){
                return false;
            }
        }
        return bbbb(seq,left,i-1)&&bbbb(seq,i,right-1);
    }
}