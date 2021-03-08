public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass innerClass = outer.new InnerClass();
        innerClass.test();
}

2、不能再实例内部类当中 定义一个静态的变量.
     *    非要定义呢？ 在编译时期能够确定的值
     class InnerClass {
        public int data1 = 100;
        public int data4=4;
        public static int data5 = 5;//错误
        public static final int data5 = 5;//正确


class OuterClass {
    public int data1=99;
    private int data2=98;
    public static int data3;
    
    class InnerClass {
        public int data1 = 100;
        public int data4=4;
        public static final int data5 = 5;
        public void test() {
            System.out.println(data1);//100
            System.out.println(this.data1);//100 内部的this
            System.out.println(OuterClass.this.data1);//99  外部的this
//3、面试问题：实例内部类是否有额外的开销？ 有    OuterClass.this
//4、this-->   静态的  OuterClass.this
// 5、注意 内部类 产生的字节码文件  外部类名$内部类名.class
            System.out.println(data2);
            System.out.println(data3);
            System.out.println(data4);
            System.out.println(data5);

        }
    }
    public static void main(String[] args) {
        OuterClass out = new OuterClass();
        OuterClass.InnerClass innerClass =new OuterClass.InnerClass(out);
        innerClass.test();
    }


*1、如何拿到静态内部类的实例对象？
     *2、静态内部类当中 是不可以访问外部类的非静态数据成员的
     *   非要访问呢？
     *//*
    static class InnerClass {
        public int data4 = 4;
        private int data5 = 5;
        public static int data6 = 6;

        OuterClass outerClass;
        //访问外部类的构造方法
        public InnerClass(OuterClass out) {
            this.outerClass = out;
        }
        public void test() {
            System.out.println(data4);
            System.out.println(data5);
            System.out.println(data6);
            System.out.println(outerClass.data1);
        }
    }
     public static void main(String[] args) {
        OuterClass out = new OuterClass();
        //拿到静态内部类的实例对象
        OuterClass.InnerClass innerClass = new OuterClass.InnerClass(out);
        //out为外部类对象的引用
        innerClass.test();
    }


class OuterClass {
    public void test(){
        System.out.println("test()");
    }
}

public class TestDemo {

    public void func() {
        class A {
            //本地内部类
        }
    }

    public static void main(String[] args) {
        //匿名内部类
        new OuterClass(){
            @Override
            public void test() {
                System.out.println("hahahahhaha");
            }
        }.test();
    }


