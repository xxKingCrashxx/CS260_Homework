package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GarageSystem extends Application{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        //FXMLLoader loader = new FXMLLoader(null)
        Parent root = FXMLLoader.load(getClass().getResource("/resources/mainLayout.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("Garage Parking System");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
    }
    
}
