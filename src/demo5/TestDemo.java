package demo5;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2020-10-26
 * Time: 11:00
 */
class Money implements Cloneable{
    public double money = 12.5;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


class Person implements Cloneable{
    public String name = "bit";

    public Money m = new Money();

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
         Person person = (Person) super.clone();
         person.m = (Money) this.m.clone();
         return person;
         //return super.clone();
    }
}
public class TestDemo {


    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        Person person2 = (Person)person.clone();


        System.out.println(person.m.money);
        System.out.println(person2.m.money);


        System.out.println("===============");
        person2.m.money = 99.99;

        System.out.println(person.m.money);
        System.out.println(person2.m.money);


    }
    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        Person person2 = (Person)person.clone();



        System.out.println(person.name);
        System.out.println(person2.name);

        System.out.println("===============");
        person2.name = "hello";
        System.out.println(person.name);
        System.out.println(person2.name);

    }
}
