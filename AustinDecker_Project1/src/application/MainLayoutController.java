package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
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
    @FXML
    private MenuItem mnuAddCar;
    @FXML
    private MenuItem mnuRemoveCar;

    private GarageSet parkedCars = new GarageSet();
    private GarageExitBag removedCars = new GarageExitBag();
    private InputBoxLayoutController inputBoxLayoutController; 

    public void saveAndExit(ActionEvent e)
    {
        GarageSet.saveGSData(parkedCars);
        removedCars.dumpOutputData();

        System.exit(0);  
    }
    
    public void exitProgram(MouseEvent me)
    {
        Alert alert = new Alert(AlertType.WARNING, "Are you sure you want to exit the program without saving?", ButtonType.YES, ButtonType.NO);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.showAndWait();

        ButtonType result = alert.getResult();
        if(result.equals(ButtonType.YES))
            System.exit(0);
        else
            return;
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
                parkedCars.checkIn(txtAddCar.getText());
                updateListView();
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

                parkedCars.checkOut(txtRemoveCar.getText(), removedCars);
                updateListView();
            }
            else{
                alert = new Alert(AlertType.ERROR, "The item you are trying to remove does not exist.");
                alert.show();
            }  

        }

    }

    public void addCarByIndex(ActionEvent ae)
    {
        
    }

    public void removeCarByIndex(ActionEvent ae)
    {
        Alert alert;
        int selectedIndex = lstParkedCarNodes.getSelectionModel().getSelectedIndex();

        if(selectedIndex < 0)
        {
            alert = new Alert(AlertType.ERROR, "No car was selected.");
            alert.show();
            return;
        }
        parkedCars.checkOut(selectedIndex, removedCars);
        updateListView();

    }

    private void updateListView()
    {
        lstParkedCarNodes.getItems().clear();
        lstRemovedCarNodes.getItems().clear();

        lstParkedCarNodes.getItems().addAll(parkedCars.toArray());
        lstRemovedCarNodes.getItems().addAll(removedCars.toArray());

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        GarageSet.loadGSData(parkedCars);
        lstParkedCarNodes.getItems().addAll(parkedCars.toArray());
    }

}
