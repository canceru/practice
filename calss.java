class MyValue{
    public int val;
}

class Calculator{
    private int num1;
    private int num2;
    public void setNum1(int num1){
        this.num1 = num1;
    }
    public void setNum2(int num2) {
        this.num2 = num2;
    }
    public int add(){
        return num1+num2;
    }
}

class Person2 {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        //age = 18;
        //name = "sangqing";
        System.out.println(age + name);
    }
    public Person2(){
        this.name = "sang qing";
        this.age = 25;
    }
    public Person2(String name,int age){
        this.name =name;
        this.age=age;
    }
}


public class TestDemo2 {
    public static void swap(MyValue myValue1,MyValue myValue2) {
        int tmp = myValue1.val;
        myValue1.val = myValue2.val;
        myValue2.val = tmp;
    }
    public static void main(String[] args) {
        MyValue myValue1 = new MyValue();
        myValue1.val = 10;
        MyValue myValue2 = new MyValue();
        myValue2.val = 20;
        System.out.println(myValue1.val+" "+myValue2.val);
        swap(myValue1,myValue2);
        System.out.println(myValue1.val+" "+myValue2.val);
    }
    public static void main2(String[] args) {
        Calculator c = new Calculator();
        c.setNum1(10);
        c.setNum2(20);
        System.out.println(c.add());
    }

    public static void main1(String[] args){
        Person2 person = new Person2();
        person.show();
        person.setAge(20);
        System.out.println(person.getAge());
        person.setName("sang");
        System.out.println(person.getName());
        Person2 person1 =new Person2("ss",30);
        person1.show();
    }
}