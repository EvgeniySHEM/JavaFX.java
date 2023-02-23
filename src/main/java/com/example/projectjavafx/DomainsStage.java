package com.example.projectjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.Timestamp;

public class DomainsStage extends Stage {
    private PersonDTO person;
    public DomainsStage(PersonDTO person) {
        this.person = person;
    }

    public void init() {
        ObservableList<Domain> list = FXCollections.observableArrayList(new Server().getDomainByPersonId(person.getId()));
        TableView<Domain> table = new TableView<>(list);

        TableColumn<Domain, Integer> id = new TableColumn<>("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        id.setMinWidth(50);
        id.setStyle("-fx-alignment: CENTER;");

        TableColumn<Domain, String> webName = new TableColumn<>("WEB NAME");
        webName.setCellValueFactory(new PropertyValueFactory<>("webName"));
        webName.setMinWidth(200);
        webName.setStyle("-fx-alignment: CENTER;");

        TableColumn<Domain, String> domainName = new TableColumn<>("DOMAIN NAME");
        domainName.setCellValueFactory(new PropertyValueFactory<>("domainName"));
        domainName.setMinWidth(50);
        domainName.setStyle("-fx-alignment: CENTER;");

        TableColumn<Domain, String> ip = new TableColumn<>("IP");
        ip.setCellValueFactory(new PropertyValueFactory<>("ip"));
        ip.setMinWidth(200);
        ip.setStyle("-fx-alignment: CENTER;");

        TableColumn<Domain, Timestamp> dateReg = new TableColumn<>("DATE REGISTRATION");
        dateReg.setCellValueFactory(new PropertyValueFactory<>("dateReg"));
        dateReg.setMinWidth(200);
        dateReg.setStyle("-fx-alignment: CENTER;");

        TableColumn<Domain, String> countryReg = new TableColumn<>("COUNTRY REGISTRATION");
        countryReg.setCellValueFactory(new PropertyValueFactory<>("countryReg"));
        countryReg.setMinWidth(200);
        countryReg.setStyle("-fx-alignment: CENTER;");

        TableColumn<Domain, Integer> personId = new TableColumn<>("PERSON ID");
        personId.setCellValueFactory(new PropertyValueFactory<>("personId"));
        personId.setMinWidth(50);
        personId.setStyle("-fx-alignment: CENTER;");

        table.getColumns().addAll(id, webName, domainName, ip, dateReg, countryReg, personId);


        StackPane root = new StackPane(table);

        Scene scene = new Scene(root,1045, 650);
        setTitle("DOMAIN TABLE");
        setScene(scene);
        initModality(Modality.APPLICATION_MODAL);
        showAndWait();
    }
}
