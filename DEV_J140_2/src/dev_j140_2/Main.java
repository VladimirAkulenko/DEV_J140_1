/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev_j140_2;

import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class Main extends Application {
    
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(15);
        root.setVgap(15);
        root.setPadding(new Insets(25, 25, 25, 25));
        
        Label labelWelcom = new Label("Welcom");
        labelWelcom.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        root.add(labelWelcom, 0, 0, 2, 1);
        
        Label labelUserName = new Label("User Name");
        root.add(labelUserName, 0, 1);
        
        TextField textFieldUserName = new TextField();
        root.add(textFieldUserName, 1, 1);
        
        Label labelPassword = new Label("Password");
        root.add(labelPassword, 0, 2);
        
        PasswordField passwordField = new PasswordField();
        root.add(passwordField, 1, 2);
        
        Button btn = new Button("Sign in");
        HBox addbutton = new HBox(10);
        addbutton.setAlignment(Pos.BOTTOM_RIGHT);
        addbutton.getChildren().add(btn);
        root.add(addbutton, 1, 4);
        
        Text actionText = new Text();
        root.add(actionText, 1, 6);
        
        btn.setOnAction(ActionEvent -> {
            List<User> users = new Repository().getUsers();
            for (User user : users) {
                if (textFieldUserName.getText().equals(user.getUserName())
                        && passwordField.getText().equals(user.getPassword())) {
                    new PersonStage().show();
                } else {
                    actionText.setFill(Color.RED);
                    actionText.setText("Пароль или логин не верный");
                }
            }
        });
        
        
        Scene scene = new Scene(root, 400, 350, Color.GAINSBORO);
        
        primaryStage.setTitle("JavaFX Welcom");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
