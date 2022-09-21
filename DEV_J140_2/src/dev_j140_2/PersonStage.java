/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev_j140_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class PersonStage {
      private Stage stage;
      
      Map<Integer, List<Domain>> domainOfPersonMap = new HashMap<>();

    public Map<Integer, List<Domain>> getDomainOfPersonMap() {
        return domainOfPersonMap;
    }
    
    public void show(){
        stage = new Stage();
        VBox root = new VBox();
        List<PersonTable> personTableList = new ArrayList<>();
        
        List<Person> personList = new Repository().getPersons();
        for(Person person : personList){
            List<Domain> domainListOfPerson = new Repository().getDomainByPerson(person);
            int idPerson = person.getId();
            domainOfPersonMap.put(idPerson, domainListOfPerson);
            int numberOfDomain = new Repository().getDomainByPerson(person).size();
            personTableList.add(new PersonTable(person.getId(), 
                    person.getJobtitle(), 
                    person.getFirstnamelastname(), 
                    person.getPhone(), 
                    person.getEmail(), 
                    numberOfDomain));
        }
        
        ObservableList<PersonTable> observableList = FXCollections.observableArrayList(personTableList);
        TableView<PersonTable> table = new TableView<PersonTable>(observableList);
        
        TableColumn<PersonTable, Integer> idColumn = new TableColumn<>("Идентификатор");
        idColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, Integer>("id"));
        table.getColumns().add(idColumn);
        
        TableColumn<PersonTable, String> jobtitleColumn = new TableColumn<>("Профессия");
        jobtitleColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("jobtitle"));
        table.getColumns().add(jobtitleColumn);
        
        TableColumn<PersonTable, String> firstnamelastnameColumn = new TableColumn<>("Имя Фамилия");
        firstnamelastnameColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("firstnamelastname"));
        table.getColumns().add(firstnamelastnameColumn);
        
        TableColumn<PersonTable, String> phoneColumn = new TableColumn<>("Телефон");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("phone"));
        table.getColumns().add(phoneColumn);
        
        TableColumn<PersonTable, String> emailColumn = new TableColumn<>("Электронная почта");
        emailColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("email"));
        table.getColumns().add(emailColumn);
        
        TableColumn<PersonTable, Integer> numberofdomainsColumn = new TableColumn<>("Кол-во доменов");
        numberofdomainsColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, Integer>("numberofdomains"));
        table.getColumns().add(numberofdomainsColumn);
        
        table.setRowFactory(tv -> {
            TableRow<PersonTable> row = new TableRow<>();
            row.setOnMouseClicked(e -> {
                if(e.getClickCount() == 2 && (!row.isEmpty())){
                    PersonTable personTableSelected = row.getItem();
                    Integer idPerson = personTableSelected.getId();
                    new DomainStage(stage, personTableSelected, domainOfPersonMap.get(idPerson)).show();;
                }
            });
            return row;
        });
        
        root.getChildren().add(table);
        Scene scene = new Scene(root, 1000, 500);
        
        stage.setTitle("Persons");
        stage.setScene(scene);
        stage.show();
    }
}
