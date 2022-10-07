package application;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import structures.CarDataNode;
import structures.GarageExitBag;
import structures.GarageSet;

public class MainLayoutController 
{
    @FXML
    private TextField txtRemoveCar;
    @FXML
    private TextField txtAddCar;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ListView<CarDataNode> lstParkedCarNodes;
    @FXML
    private ListView<CarDataNode> lstRemovedCarNodes;

    private GarageSet parkedCars = new GarageSet();
    private GarageExitBag removedCars = new GarageExitBag();


    public void exitProgram(MouseEvent mouseEvent)
    {
        System.exit(0);
    }
    
}
