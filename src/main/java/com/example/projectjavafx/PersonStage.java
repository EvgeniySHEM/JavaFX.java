package com.example.projectjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PersonStage extends Stage {
     public void init() {
         ObservableList<PersonDTO> list = FXCollections.observableArrayList(new Server().getAllPersonDTO());
         TableView<PersonDTO> table = new TableView<>(list);

         TableColumn<PersonDTO, Integer> idPerson = new TableColumn<>("ID");
         idPerson.setCellValueFactory(new PropertyValueFactory<>("id"));
         idPerson.setMinWidth(50);
         idPerson.setStyle("-fx-alignment: CENTER;");

         TableColumn<PersonDTO, String> personJob = new TableColumn<>("JOB TITLE");
         personJob.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
         personJob.setMinWidth(200);
         personJob.setStyle("-fx-alignment: CENTER;");

         TableColumn<PersonDTO, String> personName = new TableColumn<>("NAME");
         personName.setCellValueFactory(new PropertyValueFactory<>("firstNameLastName"));
         personName.setMinWidth(200);
         personName.setStyle("-fx-alignment: CENTER;");

         TableColumn<PersonDTO, String> personPhone = new TableColumn<>("PHONE");
         personPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
         personPhone.setMinWidth(200);
         personPhone.setStyle("-fx-alignment: CENTER;");

         TableColumn<PersonDTO, String> personEmail = new TableColumn<>("EMAIL");
         personEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
         personEmail.setMinWidth(250);
         personEmail.setStyle("-fx-alignment: CENTER;");

         TableColumn<PersonDTO, Integer> countDomains = new TableColumn<>("COUNT DOMAINS");
         countDomains.setCellValueFactory(new PropertyValueFactory<>("countDomains"));
         countDomains.setMinWidth(50);
         countDomains.setStyle("-fx-alignment: CENTER;");

         table.getColumns().addAll(idPerson, personJob, personName, personPhone, personEmail, countDomains);

         table.setOnMouseClicked(e -> {
             if(e.getClickCount()==2) {
                 PersonDTO person = table.getSelectionModel().getSelectedItem();
                 new DomainsStage(person).init();
             }
         });

         StackPane root = new StackPane(table);

         Scene scene = new Scene(root,1040, 650);
         setTitle("PERSONS TABLE");
         setScene(scene);
         show();
     }
}
