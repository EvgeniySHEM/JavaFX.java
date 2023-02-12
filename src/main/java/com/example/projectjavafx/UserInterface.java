package com.example.projectjavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UserInterface extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Server server = new Server();

        Label welcome = new Label("Welcome");
        welcome.setFont(Font.font(31));

        Label userName = new Label("User Name:");
        userName.setFont(Font.font(16));
        TextField userNameField = new TextField();

        Label password = new Label("Password:");
        password.setFont(Font.font(16));
        PasswordField passwordField = new PasswordField();

        Button singIn = new Button("Sing in");
        singIn.setOnAction(e -> server.signIn(userNameField, passwordField));

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.getColumnConstraints().add(new ColumnConstraints(100));
        root.setGridLinesVisible(false);
        root.setHgap(5);
        root.setVgap(10);

        root.add(welcome, 0,0,3,1);

        root.add(userName, 0, 1, 1, 1);
        root.add(userNameField, 1, 1, 3, 1);

        root.add(password, 0, 2, 1, 1);
        root.add(passwordField, 1, 2, 3, 1);

        root.add(singIn,3, 5, 1,1);
        GridPane.setMargin(singIn, new Insets(0,0,0,100));
        singIn.setPrefWidth(80);

        Scene scene = new Scene(root, 600, 500);

        stage.setTitle("JavaFX Welcome");

        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
