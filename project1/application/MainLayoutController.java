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
import structures.CarDataNode;
import structures.GarageExitBag;
import structures.GarageSet;

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
        if(txtAddCar.getText().equals(""))
        {
            Alert alert = new Alert(AlertType.ERROR, "There was no input in the textbox");
            alert.show();
        }
        else
        {
            parkedCars.checkIn(txtAddCar.getText());
            lstParkedCarNodes.getItems().add("dfdfdsfs");

            CarDataNode cursor = parkedCars.getHead();
        }
    }

    
    
}
