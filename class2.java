class Person{
    public int age;
    public String name;
    public String sex;
    public static int count;
    public void eat(){
        System.out.println("吃饭");
    }
    public static void change(){
        count=100;
    }
}
public class TestDemo {
    public static void main1(String[] args) {
        Person person = new Person();
        person.age = 19;
        person.name = "sangqing";
        person.sex = "男";
        //person.count++;
        person.eat();
        Person.change();
        System.out.println(person.age);
        System.out.println(person.name);
        System.out.println(person.sex);
        System.out.println(Person.count);
    }
}