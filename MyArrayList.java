public class MyArrayList {
    public int[] elem;
    public int usedSize;
    public MyArrayList(){
        this.elem = new int[10];
        this.usedSize = 0;
    }
    public MyArrayList(int capacity){
        this.elem = new int[capacity];
        this.usedSize = 0;
    }

    // 在 pos 位置新增元素
    public void add(int pos,int data){
        if(pos<0 || pos>this.usedSize) {
            System.out.println("位置不合法");
            return;
        }
        if(this.usedSize == this.elem.length) {
            System.out.println("位置已满");
            return;
        }
        for (int i = this.usedSize-1;  i>=pos ; i--) {
            elem[i+1]=elem[i];
        }
        elem[pos] = data;
        this.usedSize++;
    }
    public void display(){
        for (int i = 0; i <usedSize ; i++) {
            System.out.print(this.elem[i]+" ");
        }
    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize ; i++) {
            if(this.elem[i] == toFind){
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind){
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos){
        if(pos<0 || pos>=this.usedSize) {
            System.out.println("位置不合法");
            return -1;
        }
        return elem[pos];
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value){
        if(pos<0 || pos>=this.usedSize) {
            System.out.println("位置不合法");
            return ;
        }
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove){
        for (int i = 0; i < this.usedSize ; i++) {
            if(this.elem[i] == toRemove){
                for (int j = i; j <this.usedSize-1 ; j++) {
                    this.elem[j]  = this.elem[j+1];
                }
            }else{
                System.out.println("没有这个数字");
                return;
            }
        }
        this.usedSize--;
    }
    // 获取顺序表长度
    public int size() {
        return usedSize;
    }
    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
    }
}

//测试
public class TestDemo {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList(5);
        //myArrayList.add(0,1);
        myArrayList.add(0,2);
        myArrayList.add(0,3);
        myArrayList.add(0,3);
        myArrayList.add(0,5);
        myArrayList.display();
        myArrayList.remove(10);
        System.out.println();
        myArrayList.display();
    }
}