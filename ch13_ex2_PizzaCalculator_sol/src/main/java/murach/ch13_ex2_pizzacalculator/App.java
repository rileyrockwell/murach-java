package murach.ch13_ex2_pizzacalculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    // class globals
    private ToggleGroup sizeToggle = new ToggleGroup();
    private CheckBox sausageBox = new CheckBox("Sausage");
    private CheckBox peppBox = new CheckBox("Pepperoni");
    private CheckBox salamiBox = new CheckBox("Salami");
    private CheckBox oliveBox = new CheckBox("Olives");
    private CheckBox mushBox = new CheckBox("Mushrooms");
    private CheckBox anchBox = new CheckBox("Anchovies");
    private TextField priceField = new TextField();
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Pizza Price Calculcator");
        GridPane grid = new GridPane();
        VBox appContainer = new VBox(10);
        // size
        Label sizeLabel = new Label("Size");
        HBox sizeBox = new HBox(10);        
        
        RadioButton smallButton = new RadioButton("Small");
        smallButton.setToggleGroup(sizeToggle);
        smallButton.setSelected(true);
        RadioButton mediumButton = new RadioButton("Medium");
        mediumButton.setToggleGroup(sizeToggle);
        RadioButton largeButton = new RadioButton("Large");
        largeButton.setToggleGroup(sizeToggle);

        sizeBox.getChildren().add(smallButton);
        sizeBox.getChildren().add(mediumButton);
        sizeBox.getChildren().add(largeButton);
        appContainer.getChildren().add(sizeLabel);
        appContainer.getChildren().add(sizeBox);
        
        // toppings
        Label toppingsLabel = new Label("Toppings");
        HBox sizeContainer = new HBox(10);
        VBox sizeCol1 = new VBox(10);
        VBox sizeCol2 = new VBox(10);
        
        sizeCol1.getChildren().add(sausageBox);
        sizeCol1.getChildren().add(peppBox);
        sizeCol1.getChildren().add(salamiBox);
        sizeCol2.getChildren().add(oliveBox);
        sizeCol2.getChildren().add(mushBox);
        sizeCol2.getChildren().add(anchBox);
        sizeContainer.getChildren().add(sizeCol1);
        sizeContainer.getChildren().add(sizeCol2);
        appContainer.getChildren().add(toppingsLabel);
        appContainer.getChildren().add(sizeContainer);

        // price output
        Label priceLabel = new Label("Price: ");
        HBox priceContainer = new HBox(10);
        priceField.setEditable(false);
        priceContainer.getChildren().add(priceLabel);
        priceContainer.getChildren().add(priceField);
        appContainer.getChildren().add(priceContainer);
        
        // calculate button
        Button signUpButton = new Button("Calculate");        
        signUpButton.setOnAction(event -> calculatePrice(stage));
        appContainer.getChildren().add(signUpButton);

        grid.add(appContainer, 0, 5);
        grid.setPadding(new Insets(10, 10, 0, 10));
        Scene scene = new Scene(grid, 225, 250);
        stage.setScene(scene);
        stage.show();
    }

    public void calculatePrice(Stage stage) {
        double price = 0.0;
        RadioButton size = 
                (RadioButton) sizeToggle.getSelectedToggle();
        if(size.getText() == "Small") {
            price += 6.99;
        } else if(size.getText() == "Medium") {
            price += 8.99;
        } else {
            price += 10.99;
        }

        if(sausageBox.isSelected()) {
            price += 1.49;
        }
        if(peppBox.isSelected()) {
            price += 1.49;
        }
        if(salamiBox.isSelected()) {
            price += 1.49;
        }
        if(oliveBox.isSelected()) {
            price += 0.99;
        }
        if(mushBox.isSelected()) {
            price += 0.99;
        }
        if(anchBox.isSelected()) {
            price += 0.99;
        }
        price = (double)Math.round(price * 100.0) / 100.0;
        priceField.setText("$" + price);
    }

    public static void main(String[] args) {
        launch();
    }
}