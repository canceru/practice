package sample;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Main extends Application {

    private static Parent build() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        TextField textField = new TextField();
        gridPane.add(textField, 0, 0);

        Button button = new Button();
        button.setText("click me");
        gridPane.add(button, 0, 1);

        Label label = new Label();
        label.setPrefWidth(200);
        label.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 5");
        gridPane.add(label, 0, 2);

        Controller controller = new Controller();
        controller.inputField = textField;
        controller.outputLabel = label;

        //button.setOnMouseClicked(controller::点击事件);
        //button.setOnMouseClicked(event -> controller.点击事件(event));
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                controller.点击事件(mouseEvent);
            }
        });






        // 关于“表”的实验
        TableView<Student> tableView = new TableView<>();
        gridPane.add(tableView, 0, 3);
        controller.tableView = tableView;

        // 表中有哪些列
        TableColumn<Student, String> idColumn = new TableColumn<>();
        idColumn.setText("#ID");
        idColumn.setCellValueFactory(param -> param.getValue().getIdValue());
        tableView.getColumns().add(idColumn);

        TableColumn<Student, String> nameColumn = new TableColumn<>();
        nameColumn.setText("姓名");
        nameColumn.setCellValueFactory(param -> param.getValue().getNameValue());
        tableView.getColumns().add(nameColumn);

        TableColumn<Student, String> ageColumn = new TableColumn<>();
        ageColumn.setText("年龄");
        ageColumn.setCellValueFactory(param -> param.getValue().getAgeValue());
        tableView.getColumns().add(ageColumn);

        TableColumn<Student, String> genderColumn = new TableColumn<>();
        genderColumn.setText("性别");
        genderColumn.setCellValueFactory(param -> param.getValue().getGenderValue());
        tableView.getColumns().add(genderColumn);
        // 关于“表”的实验结束







        return gridPane;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //Parent root = build();
        Parent root = FXMLLoader.load(getClass().getResource("file-scan.fxml"));
        primaryStage.setTitle("陈沛鑫");
        Scene scene = new Scene(root, 1100, 550);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
