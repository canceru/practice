import book.BookList;
import operation.IOperation;
import user.Admin;
import user.NormalUser;
import user.User;

import java.util.Scanner;


public class Main {

    public static User login() {
        System.out.println("请输入你的名字：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("请输入你的身份，1是管理员,0是普通用户");
        int choice = scanner.nextInt();
        if(choice == 1) {
            return new Admin(name);
        }else {
            return new NormalUser(name);
        }
    }

    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();//向上转型
        while (true) {
            int choice = user.menu();//1
            IOperation iOperation = user.doOperation(choice);
            iOperation.work(bookList);
        }
    }
}
