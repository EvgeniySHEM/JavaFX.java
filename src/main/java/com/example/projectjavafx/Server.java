package com.example.projectjavafx;

import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private final String dbURL;
    private final String dbUserName;
    private final String dbPassword;
    private String login;
    private String password;

    public Server() throws IOException {
        Properties properties = new Properties();
        File propertyFile = new File("property.prop");
        if (!propertyFile.exists()) propertyFile.createNewFile();
        try {
            properties.load(new FileReader(propertyFile));
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbURL = properties.getProperty("db.url");
        dbUserName = properties.getProperty("db.user");
        dbPassword = properties.getProperty("db.password");
    }

    public void signIn(TextField userNameField, PasswordField passwordField) {
        login = userNameField.getText();
        password = passwordField.getText();

        if (readUsers()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("login and password verification");
            alert.setContentText("Authentication completed successfully");
            alert.showAndWait();
        } else {
            userNameField.clear();
            passwordField.clear();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("login and password verification");
            alert.setHeaderText("Authentication failed!");
            alert.setContentText("Incorrect username or password");
            alert.showAndWait();
        }
    }

    private boolean readUsers() {
        try (Connection connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT NAME, PASSWORD FROM USERS")) {
            resultSet.next();
            if (resultSet.getString(1).equals(login) && resultSet.getString(2).equals(password))
                return true;

        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
