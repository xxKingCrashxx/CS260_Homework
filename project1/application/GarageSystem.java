package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GarageSystem extends Application{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 500, 500);
        // TODO Auto-generated method stub

        primaryStage.setTitle("Garage Parking System");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
    }
    
}
