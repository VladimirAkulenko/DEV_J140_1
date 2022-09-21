/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev_j140_2;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class DomainStage {
    private Stage stage;
    private Stage ownerStage;
    private List<Domain> domainList;
    private PersonTable personTableSelected;
    
    public DomainStage(Stage ownerStage, PersonTable personTableSelected, List<Domain> domainList) {
        this.ownerStage = ownerStage;
        this.domainList = domainList;
        this.personTableSelected = personTableSelected;
    }
    
    public void show(){
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(ownerStage);
        VBox root = new VBox();
        List<DomainTable> domainTableList = new ArrayList<>();
        
        for(Domain domain : domainList){
            domainTableList.add(new DomainTable(domain.getId(), 
                    domain.getWebname(), 
                    domain.getDomainname(), 
                    domain.getIp(), 
                    domain.getDatereg(), 
                    domain.getCountryreg(),
                    domain.getPerson()));
        }

        ObservableList<DomainTable> observableList = FXCollections.observableArrayList(domainTableList);
        TableView<DomainTable> table = new TableView<DomainTable>(observableList);
        
        TableColumn<DomainTable, Integer> idColumn = new TableColumn<>("Идентификатор");
        idColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, Integer>("id"));
        table.getColumns().add(idColumn);
        
        TableColumn<DomainTable, String> webnameColumn = new TableColumn<>("Web имя");
        webnameColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("webname"));
        table.getColumns().add(webnameColumn);
        
        TableColumn<DomainTable, String> domainnameColumn = new TableColumn<>("Доменное имя");
        domainnameColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("domainname"));
        table.getColumns().add(domainnameColumn);
        
        TableColumn<DomainTable, String> ipColumn = new TableColumn<>("Ip");
        ipColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("ip"));
        table.getColumns().add(ipColumn);
        
        TableColumn<DomainTable, Timestamp> dateregColumn = new TableColumn<>("Дата регистрации");
        dateregColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, Timestamp>("datereg"));
        table.getColumns().add(dateregColumn);
        
        TableColumn<DomainTable, String> countryregColumn = new TableColumn<>("Страна регистрации");
        countryregColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("countryreg"));
        table.getColumns().add(countryregColumn);
        
        
        
        root.getChildren().add(table);
        Scene scene = new Scene(root, 800, 500);
        
        stage.setTitle("Domain");
        stage.setScene(scene);
        stage.show();
    }
}
