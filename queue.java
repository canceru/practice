import java.util.LinkedList;
import java.util.Queue;

//顺序栈 +  链式队列
class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}

class MyQueue {
    public Node head;
    public Node tail;

    public void offer(int val) {
        Node node = new Node(val);
        if(this.head == null) {
            this.head = node;
            this.tail = node;
            return;
        }
        this.tail.next = node;
        this.tail = node;
    }

    public int poll() {
        if(this.head == null) {
            throw new RuntimeException("队列为空\n");
        }
        int oldData = this.head.val;
        if(this.head.next == null) {
            this.head = null;
            this.tail = null;
        }else {
            this.head = this.head.next;
        }
        return oldData;
    }

    public int peek() {
        if(this.head == null) {
            throw new RuntimeException("队列为空\n");
        }
        return this.head.val;
    }

    public boolean isEmpty() {
        if(this.head == null) {
            return true;
        }
        return false;
    }

}


public class TestDemo3 {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());

    }
    public static void main1(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
       /* queue.add(1);
        queue.add(2);
        queue.add(3);*/
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        //弹出
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.isEmpty());
    }
}


class MyCircularQueue {


    public int[] elem;
    //public int usedSize;
    public int front;
    public int rear;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.elem = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        //1、判断是否为满的
        if(isFull()) {
            return false;
        }
        //2、rear -->
        this.elem[this.rear] = value;
        this.rear = (this.rear+1) % this.elem.length;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        //1、是否为空   front和rear相遇的时候
        if(isEmpty()) {
            return false;
        }
        this.front = (this.front+1)%this.elem.length;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()) {
            return -1;
        }
        return this.elem[this.front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        /*int index = this.rear==0 ? this.elem.length-1 :  this.rear-1;
        return this.elem[index];
        */
        int index = 0;
        if(this.rear == 0) {
            index = this.elem.length-1;
        }else {
            index = this.rear-1;
        }
        return this.elem[index];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(front == rear) {
            return true;
        }
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if( (this.rear+1) % this.elem.length == this.front){
            return true;
        }
        return false;
    }


}

public class TestDemo4 {
}
