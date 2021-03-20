/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14495
 * Date: 2021-03-20
 * Time: 20:55
 */


class BankAccount{
    String name;
    int year;
    double balance;
    double rate=0.01;
    public BankAccount(){
        int year = 1;
        double balance = 10;
    }
    public BankAccount(double balance,int year){
        this.balance=balance;
        this.year=year;
    }

    public void save(double newBalance){
        balance = balance+newBalance;

    }



    public double cal(){
        return balance+balance*year*rate;
    }


}


public class TestDemo {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000,3);
        bankAccount.save(2000);
        System.out.println(bankAccount.cal());
    }



}
