package com.example.projectjavafx;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UserInterface extends Application {

    @Override
    public void start(Stage stage)  {
        Server server = new Server();

        Label welcome = new Label("Welcome");
        welcome.setFont(Font.font(31));

        Label userName = new Label("User Name:");
        userName.setFont(Font.font(16));
        TextField userNameField = new TextField();

        Label password = new Label("Password:");
        password.setFont(Font.font(16));
        PasswordField passwordField = new PasswordField();

        Button singInButton = new Button("Sing in");
        singInButton.setOnAction(e -> {
            if(server.signIn(userNameField, passwordField)) {
                stage.close();
            }
        });

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

        root.add(singInButton,3, 5, 1,1);
        GridPane.setHalignment(singInButton, HPos.RIGHT);
        singInButton.setPrefWidth(80);

        Scene scene = new Scene(root, 600, 500);

        stage.setTitle("JavaFX Welcome");

        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
