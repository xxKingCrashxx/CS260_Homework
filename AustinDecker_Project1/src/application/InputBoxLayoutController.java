package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;


public class InputBoxLayoutController {
    @FXML
    TextField txtCarID;

    @FXML
    Button btnSubmit;

    @FXML
    Button btnCancel;

    public String getInput()
    {
        return txtCarID.getText(); 
    }

    public void submitCarID(MouseEvent me)
    {
        if(getInput().equals(""))
        {
            Alert alert = new Alert(AlertType.ERROR, "You did not provide a car ID.");
            alert.show();
        }
    }
}
