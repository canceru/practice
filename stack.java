class MyStack<T>{
    public T[] elem;
    public int top;
    public MyStack(){
        this.elem = (T[])new Objects[5];
    }
    public void push(T item){
        if(isFull()){
            return;
        }
        this.elem[this.top] = item;
        this.top++;
    }
    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空");
        }
        T ret = this.elem[top-1];
        this.top--;
        this.elem[top] = null;
        return ret;
    }
    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("栈为空");
            //return -1;
        }
        return this.elem[this.top-1];
    }
    public boolean isFull(){
        if(this.top == this.elem.length){
            return true;
        }
        return false;
    }
    /*public boolean isFull() {
        return this.top == this.elem.length;
    }*/
    public boolean isEmpty(){
        if(top == 0){
            return true;
        }
        return false;
    }
}

public class TestDemo {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());



        /*Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.size());*/
    }
}


class Node{
    public int val;
    public Node next;
    public Node(int val){
        this.val = val;
    }
}
class MyQueue{
    public Node head;
    public Node tail;
    public void offer(int val){
        Node node = new Node(val);
        if(this.head == null){
            this.head = node;
            this.tail = node;
            return;
        }
        this.tail.next = node;
        this.tail = node;
    }

    public int poll(){
        if(this.head == null){
            throw new RuntimeException("队列为空");
        }
        int data = this.head.val;
        if(this.head.next == null){
            this.head = null;
            this.tail = null;
        }else{
            this.head = this.head.next;
        }
        return data;
    }

    public int peek(){
        if(this.head == null){
            throw new RuntimeException("队列为空");
        }
        return this.head.val;
    }

    public boolean isEmpty(){
        if(this.head == null){
            return true;
        }
        return false;
    }
}

public class TestDemo2{
    public static void main(String[] args){
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());
    }
}


class MyCircularQueue{
    public int[] elem;
    public int front;
    public int rear;

    public MyCircularQueue(int k){
        this.elem = new int[k+1];
    }
    public boolean enQueue(int val){
        if(isFull()){
            return false;
        }
        this.elem[this.rear]=val;
        this.rear = (this.rear+1) % this.elem.length;
        return true;
    }

    public boolean deQueue(){
        if(isEmpty()){
            return false;
        }
        this.front = (this.front+1) % this.elem.length;
        return true;
    }
    //得到队列中的值
    public int Front(){
        if(isEmpty()){
            return -1;
        }
        int ret = this.elem[front];
        return ret;
    }

    //得到队尾的值
    public int Rear(){
        if(isEmpty()){
            return -1;
        }
        int index = 0;
        if(this.rear == 0){
            index = this.elem.length-1;
        }else{
            index = this.rear-1;
        }
        return this.elem[index];
    }

    public boolean isFull(){
        if((this.rear+1) % this.elem.length == this.front){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if(front == rear){
            return true;
        }
        return false;
    }
}


public class TestDemo3 {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(5);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(3);

    }
}
