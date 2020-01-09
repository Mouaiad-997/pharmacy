package pharmacy;

import java.io.IOException;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BuyDrug {

    @FXML
    private TextField namee;
    @FXML
    private TextField pricee;
    @FXML
    private TextField themanufacturecompanyy;
    @FXML
    private TextField typeoftreatmentt;
    @FXML
    private DatePicker thedateofpurchasee;
    @FXML
    private DatePicker expirationdatee;

    public void buydrug(ActionEvent e) throws IOException {
        LocalDate datepurchase = thedateofpurchasee.getValue();
        LocalDate exdate = expirationdatee.getValue();

        String Name = namee.getText();
        String Price = pricee.getText();
        String Manufacture = themanufacturecompanyy.getText();
        String Typetreatment = typeoftreatmentt.getText();

        String datep = thedateofpurchasee.toString();
        String dateex = expirationdatee.toString();
        int pr = Integer.parseInt(Price);
        Drug Dr = new Drug();
        Dr.setName(Name);
        Dr.setPrice(pr);
        Dr.setTheManufactureCompany(Manufacture);
        Dr.setTypeOfTreatment(Typetreatment);
        Dr.setTheDateOfPurchase(datep);
        Dr.setExpirationDate(dateex);
        int status=DBinfo.Save(Dr);
        if(status>0){
           Alert alert=new Alert(AlertType.INFORMATION);
           alert.setTitle("Data Insert");
           alert.setHeaderText("Information Dialog");
           alert.setContentText("Record saved successfully!");
           alert.showAndWait();
          
           System.out.print("Record saved successfully!");
           
        }
        else{
             Alert alert=new Alert(AlertType.ERROR);
           alert.setTitle("Data Insert");
           alert.setHeaderText("Error Dialog");
           alert.setContentText("sorry!unable to save record");
           alert.showAndWait();
          
           System.out.print("Nooooooooooooo!");
            
        }
    }

}
