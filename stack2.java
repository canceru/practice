import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14495
 * Date: 2021-02-26
 * Time: 16:16
 */



class MyStack {
    private Queue<Integer> qu1;
    private Queue<Integer> qu2;
    public int usedSize;

    /** Initialize your data structure here. */
    public MyStack() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(!qu1.isEmpty()) {
            qu1.offer(x);
        }else if(!qu2.isEmpty()) {
            qu2.offer(x);
        }else {
            qu1.offer(x);
        }
        usedSize++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()) {
            return -1;
        }
        int size = usedSize;
        if(!qu1.isEmpty()) {
            for (int i = 0; i < size - 1; i++) {
                qu2.offer(qu1.poll());
            }
            usedSize--;
            return qu1.poll();
        }else{
            for (int i = 0; i <size-1 ; i++) {
                qu1.offer(qu2.poll());
            }
            usedSize--;
            return qu2.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        if(empty()) {
            return -1;
        }
        int tmp = -1;
        int size = usedSize;
        if(!qu1.isEmpty()) {
            for (int i = 0; i < size ; i++) {
                tmp = qu1.poll();
                qu2.offer(tmp);
            }
            return tmp;
        }else{
            for (int i = 0; i <size ; i++) {
                tmp = qu2.poll();
                qu1.offer(tmp);
            }
            return tmp;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(qu1.isEmpty() && qu2.isEmpty())
            return true;
        return false;
    }
}

class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        if(!s2.empty()){
            return s2.pop();
        }
        return -1;
    }

    /** Get the front element. */
    public int peek() {
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        if(!s2.empty()){
            return s2.peek();
        }
        return -1;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(s1.empty()&&s2.empty()){
            return true;
        }
        return false;
    }
}
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.empty()){
            minStack.push(x);
        }
        else if(x<=minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        int x = stack.pop();
        if(x == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}


class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char tmp = s.charAt(i);
            if(tmp == '(' || tmp=='[' || tmp=='{'){
                stack.push(tmp);
            }else{
                if(stack.empty()){
                    return false;
                }else{
                    char cur = s.charAt(i);
                    char topChar = stack.peek();
                    if(cur ==')' && topChar== '(' || cur == ']'&&topChar=='[' || cur=='}'&& topChar=='{'){
                        stack.pop();
                    }else{
                        System.out.println("右括号不匹配");
                        return false;
                    }
                }
            }
        }
        if(!stack.empty()){
            System.out.println("左括号不匹配");
            return false;
        }
        System.out.println("括号匹配");
        return true;
    }
}


public class TestDemo {
}
