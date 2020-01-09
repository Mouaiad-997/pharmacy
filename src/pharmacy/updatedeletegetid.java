
package pharmacy;

import java.io.IOException;
import java.text.ParseException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class updatedeletegetid {
    
    
    
  @FXML   
           TextField name1;
@FXML 
        TextField price1;

  @FXML   
           TextField themanufacturecompany1;
@FXML 
        TextField typeoftreatment1;
@FXML 
      TextField thedateofpurchase1;
@FXML 
      TextField expirationdate1;
@FXML 
      TextField iddrug;
public void getDrugById(ActionEvent e)throws IOException,ParseException{
 String sid=iddrug.getText(); 
 int id=Integer.parseInt(sid);
 Drug Dr=DBinfo.getDrugID(id);
 name1.setText(Dr.getName());
  price1.setText(String.valueOf(Dr.getPrice()));
   themanufacturecompany1.setText(Dr.getTheManufactureCompany());
   typeoftreatment1.setText(Dr.getTypeOfTreatment());
      thedateofpurchase1.setText(Dr.getTheDateOfPurchase());
expirationdate1.setText(Dr.getExpirationDate());
}

 public void updateEmployee(ActionEvent e) throws IOException,ParseException{
 String sid=iddrug.getText();
 int id=Integer.parseInt(sid);
 String Name=name1.getText();
 String pr=price1.getText();
  int price=Integer.parseInt(pr);
 String themanufacturecompany=themanufacturecompany1.getText();
 String typeoftreatment=typeoftreatment1.getText();
 String thedateofpurchase=thedateofpurchase1.getText();
 String expirationdate=expirationdate1.getText();
     
 Drug DD=new Drug();
 DD.setId(id);
 DD.setName(Name);
 DD.setPrice(price);
 DD.setTheManufactureCompany(themanufacturecompany);
 DD.setTypeOfTreatment(typeoftreatment);
 DD.setTheDateOfPurchase(thedateofpurchase);
 DD.setExpirationDate(expirationdate);
 
 int status=DBinfo.Update(DD);
 if(status>0)
 {Alert alert =new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("Data Insert");
           alert.setHeaderText("Information Dialog");
           alert.setContentText("Record saved successfully!");
           alert.showAndWait();
          
           System.out.print("Record saved successfully!");
           
        }
  else{
             Alert alert=new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Data Insert");
           alert.setHeaderText("Error Dialog");
           alert.setContentText("sorry!unable to save record");
           alert.showAndWait();
          
           System.out.print("Nooooooooooooo!");
            
        }
 
 }
 public void deleteDrugById(ActionEvent e)throws IOException,ParseException{
 String sid=iddrug.getText(); 
 int id=Integer.parseInt(sid);
 
 DBinfo.Delete(id);
 int status=DBinfo.Delete(id);
 if(status>0)
      {Alert alert =new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("Data Insert");
           alert.setHeaderText("Information Dialog");
           alert.setContentText("Record saved successfully!");
           alert.showAndWait();
          
           System.out.print("Record saved successfully!");
           
        }
  else{
             Alert alert=new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Data Insert");
           alert.setHeaderText("Error Dialog");
           alert.setContentText("sorry!unable to save record");
           alert.showAndWait();
          
           System.out.print("Nooooooooooooo!");
            
        
 
}
    
}
}

