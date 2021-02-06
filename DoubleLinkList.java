class LinkNode{
    public int data;
    public LinkNode next;
    public LinkNode prev;
    public LinkNode(int data){
        this.data = data;
    }
}
public class DoubleList {
    public LinkNode head;
    public  LinkNode last;
    //头插法
    public void addFirst(int data) {
        LinkNode node = new LinkNode(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }
    //尾插法
    public void addLast(int data) {
        LinkNode node = new LinkNode(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        LinkNode node = new LinkNode(data);
        LinkNode cur =this.head;
        if(index < 0 || index > size()){
            System.out.println("输入不合法！");
            return ;
        }
        if(index == 0){
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
            return;
        }
        if(index == size()){
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
            return;
        }
        while (index > 0){
            cur =cur.next;
            index--;
        }
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        LinkNode cur = this.head;
        while(cur != null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        LinkNode cur = this.head;
        while(cur != null){
            if(cur.data == key){
                if(this.head.data == key){
                    head = head.next;
                    head.prev = null;
                }else{
                    if(cur.next != null){
                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                    }else{
                        this.last = this.last.prev;
                        this.last.next = null;
                    }
                }
                return;
            }else{
                cur = cur.next;
            }
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        LinkNode cur = this.head;
        while(cur != null){
            if(cur.data == key){
                if(this.head.data == key){
                    if(this.head.next == null){
                        this.head = null;
                        return;
                    }
                    head = head.next;
                    head.prev = null;
                }else{
                    if(cur.next != null){
                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                    }else{
                        this.last = this.last.prev;
                        this.last.next = null;
                    }
                }
            }
            cur = cur.next;
        }
    }
    //得到单链表的长度
    public int size(){
        LinkNode cur = this.head;
        int count = 0;
        while(cur != null){
            cur =cur.next;
            count++;
        }
        return count;
    }
    public void display(){
        LinkNode cur = this.head;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur =cur.next;
        }
        System.out.println();
    }
}


//TestDemo
public static void main(String[] args) {
        DoubleList doubleList = new DoubleList();
        doubleList.addFirst(1);
        doubleList.addFirst(2);
        doubleList.addFirst(3);
        doubleList.addFirst(4);
        doubleList.display();
        doubleList.addLast(3);
        doubleList.addLast(2);
        doubleList.addLast(3);
        doubleList.addLast(3);
        doubleList.display();
        System.out.println(doubleList.size());
        System.out.println(doubleList.contains(4));
        doubleList.addIndex(0,5);
        doubleList.display();
        doubleList.remove(5);
        doubleList.display();
        doubleList.removeAllKey(3);
        doubleList.display();
    }
