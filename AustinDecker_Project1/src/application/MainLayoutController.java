package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import structure.GarageExitBag;
import structure.GarageSet;

public class MainLayoutController implements Initializable
{
    @FXML
    private TextField txtRemoveCar;
    @FXML
    private TextField txtAddCar;
    @FXML
    private ListView<String> lstParkedCarNodes;
    @FXML
    private ListView<String> lstRemovedCarNodes;

    private GarageSet parkedCars = new GarageSet();
    private GarageExitBag removedCars = new GarageExitBag();

    public MainLayoutController()
    {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void exitProgram(MouseEvent mouseEvent)
    {
        System.exit(0);
    }

    public void addCarByID(MouseEvent mouseEvent)
    {
        Alert alert;

        if(txtAddCar.getText().equals(""))
        {
            alert = new Alert(AlertType.ERROR, "There was no input in the textbox.");
            alert.show();
        }
        else
        {

            if(!parkedCars.hasDuplicate(txtAddCar.getText()))
            {
                lstParkedCarNodes.getItems().clear();
                parkedCars.checkIn(txtAddCar.getText());
                lstParkedCarNodes.getItems().addAll(parkedCars.toArray());
            }
            else
            {
                alert = new Alert(AlertType.ERROR, "This item has already been added.");
                alert.show();
            }
        }
    }

    public void removeCarByID(MouseEvent mouseEvent)
    {
        Alert alert;
        
        if(txtRemoveCar.getText().equals(""))
        {
            alert = new Alert(AlertType.ERROR, "There was no input in the textbox");
            alert.show();
        }
        else
        {
            if(parkedCars.hasDuplicate(txtRemoveCar.getText())){
                lstParkedCarNodes.getItems().clear();
                lstRemovedCarNodes.getItems().clear();
                
                parkedCars.checkOut(txtRemoveCar.getText(), removedCars);
                lstParkedCarNodes.getItems().addAll(parkedCars.toArray());
                lstRemovedCarNodes.getItems().addAll(removedCars.toArray());
            }
            else{
                alert = new Alert(AlertType.ERROR, "The item you are trying to remove does not exist.");
                alert.show();
            }  

        }

    }

}
