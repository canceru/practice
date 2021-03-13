package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Date;

public class Controller {
    @FXML
    public TextField inputField;
    public Label outputLabel;

    /*public void 点击(MouseEvent mouseEvent) {
        System.out.println(new Date()+"点击了一下");
        // 从输入框中读取文字内容
        String inputText = inputField.getText();
        System.out.println("用户输入了"+inputText);
        outputLabel.setText(inputText);
    }*/


    // thread 的所有读写操作其实都在主线程中，所以不需要考虑线程安全的问题
    private Thread thread = null;

    @FXML
    public void 点击事件(MouseEvent mouseEvent) {
        System.out.println(new Date() + ": 按钮被点击");
        // 从输入框中读取文字内容

        String inputText = inputField.getText();
        System.out.println("用户输入了: " + inputText);

        try {
            int n = Integer.parseInt(inputText.trim());
            // 主线程
            if (thread != null) {
                thread.interrupt();
            }

            thread = new Thread(() -> {
                long r = fib(n);    // <--- 目前在子线程中进行
                // <--- 在 UI 中，主线程的核心工作是响应事件
                // <--- 解决办法：不要把可能耗时比较久的操作，放到主线程中进行

                // 涉及 UI 修改的，最好回到主线程中进行
                // 如果多个线程同时操作 UI 界面，可能有线程安全问题
                System.out.printf("fib(%d) = %d\n", n, r);
                if (Thread.interrupted()) {
                    return;
                }
                Platform.runLater(() -> {
                    // 以事件方式通知主线程执行该操作
                    // 主线程中
                    outputLabel.setText(String.valueOf(r));
                    thread = null;
                });
            });
            thread.start();
        } catch (NumberFormatException exc) {
            outputLabel.setText("请输入合法的数字");
        }
    }

    // 故意使用特别慢的及算法方式，时间复杂度是 O(2^n)
    private long fib(int n) {
        if (n < 2) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
