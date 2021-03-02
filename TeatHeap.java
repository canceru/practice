public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap() {
        this.elem = new int[10];
    }

    public void adjustDown(int parent, int len) {
        int child = 2 * parent + 1;
        while (child < len) {
            if (child + 1 < len && elem[child] < elem[child + 1]) {
                child++;
            }
            if (elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }
    public void initHeap(int[] array){
        for (int i = 0; i <array.length ; i++) {
            this.elem[i]= array[i];
            this.usedSize++;
        }
        for (int i = (this.usedSize-1-1)/2; i >=0 ; i--) {
            adjustDown(i,usedSize);
        }
        System.out.println("======");
    }
    //向上调整
    public void adjustUp(int child){
        int parent =(child-1)/2;
        while(child>0){
            if(elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;
                parent = (child-1)/2;
            }else{
                break;
            }
        }
    }
    
    public void push(int val){
        //扩容
        if(isFull()){
            this.elem= Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.elem[this.usedSize] =val;
        this.usedSize++;
        adjustUp(this.usedSize-1);
    }
    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }
    public void pop(){
        if(isEmpty())return;
        //1、交换堆顶和最后一个元素
        int tmp = this.elem[0];
        this.elem[0] = this.elem[this.usedSize-1];
        this.elem[this.usedSize-1] = tmp;
        this.usedSize--;
        //2、
        adjustDown(0,this.usedSize);
        System.out.println("============");
    }
    public boolean isEmpty() {
        return this.usedSize == 0;
    }

}
