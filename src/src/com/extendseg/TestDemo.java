package com.extendseg;


class Animal {
    protected String name;
    public Animal(String name) {
        //eat(); 坑
        this.name = name;
    }
    public void eat() {
        System.out.println(this.name+" eat()");
    }
}

class Cat extends Animal{
    public Cat(String name) {
        super(name);//显示调用父类的构造方法
    }

    @Override
    public void eat() {
        System.out.println(this.name+ "Cat::eat()");
    }

    public void func() {
        System.out.println("Cat::func()");
    }
}

class Dog extends Animal{

    public Dog(String name) {
        super(name);
    }
    public void wangwang() {
        System.out.println(this.name+"wangwang");
    }
}

/*class Base {
    public int a;
}

class Derieve  extends  Base{
    int b;
}*/

public class TestDemo {

    public static void main(String[] args) {
        Animal animal2 = new Cat("mimi");

    }

    public static void main4(String[] args) {
        Animal animal2 = new Cat("mimi");
        animal2.eat();

       /* Cat cat = (Cat) animal2;
        cat.func();*/

        Animal animal3 = new Dog("旺财");

        if(animal3 instanceof Dog) {
            Dog dog = (Dog) animal3;
            dog.wangwang();
        }


    }




   public static void func1(Animal animal) {

   }

   public static Animal func2() {
       Dog dog = new Dog("旺财");
       return dog;
   }


    public static void main3(String[] args) {
        Animal animal2 = new Cat("mimi");
        animal2.eat();

        Dog dog = new Dog("旺财");
        func1(dog);

    }

    public static void main2(String[] args) {
        Animal animal = new Animal("fafa");
        System.out.println(animal.name);
    }


    public static void main1(String[] args) {
        Dog dog = new Dog("旺财");
        dog.eat();
        dog.wangwang();
        /*Cat cat = new Cat();
        cat.name = "旺财";
        cat.eat();*/
        /*Derieve derieve = new Derieve();
        System.out.println(derieve.a);
        System.out.println(derieve.b);*/
    }
}
