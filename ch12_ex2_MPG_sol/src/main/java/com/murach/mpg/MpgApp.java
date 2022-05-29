package com.murach.mpg;

import java.text.NumberFormat;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MpgApp extends Application {
    private TextField milesField;
    private TextField gallonsField;
    private TextField mpgField;

    @Override
    public void start(Stage stage) {
        stage.setTitle("MPG Calculator");
                
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25)); 
       
        Scene scene = new Scene(grid, 275, 175);
        
        grid.add(new Label("Miles:"), 0, 0);
        milesField = new TextField();
        grid.add(milesField, 1, 0);

        grid.add(new Label("Gallons:"), 0, 1);
        gallonsField = new TextField();
        grid.add(gallonsField, 1, 1);
        
        grid.add(new Label("MPG:"), 0, 2);
        mpgField = new TextField();
        mpgField.setEditable(false);
        grid.add(mpgField, 1, 2);
        
        Button btn = new Button();
        btn.setText("Calculate");
        btn.setOnAction(event -> buttonClicked());
        grid.add(btn, 1, 3);
        
        stage.setScene(scene);
        stage.show();
    }
    
    private void buttonClicked() {
        Validation v = new Validation();  
        
        String errorMsg = "";
        errorMsg += v.isDouble(milesField.getText(), "Miles");
        errorMsg += v.isDouble(gallonsField.getText(), "Gallons");

        if (errorMsg.isEmpty()) {
            double miles = Double.parseDouble(milesField.getText());
            double gallons = Double.parseDouble(gallonsField.getText());
            double mpg = miles / gallons;

            NumberFormat num = NumberFormat.getNumberInstance();
            mpgField.setText( num.format(mpg) );  
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Data");
            alert.setContentText(errorMsg);
            alert.showAndWait();        
        }
    }

    public static void main(String[] args) {
        launch();
    }

}