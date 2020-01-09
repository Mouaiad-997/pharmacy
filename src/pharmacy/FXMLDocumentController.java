package pharmacy;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;




public class FXMLDocumentController {
    
@FXML 
        Label dbConlb;
@FXML 
       TextField username;
@FXML 
        TextField password;
@FXML 
        Label check;


    public void statusDB(ActionEvent e) throws IOException, SQLException {

        if (!AdminsDB.getConnection().isClosed()) {
            dbConlb.setText("Connected...");
        } else {
            dbConlb.setText("Not Connected");
        }
    }
   public void enterCP(ActionEvent e)throws IOException,SQLException{

       List<Admins> list=AdminsDB.getAdmins();
 
       Map<String,String> map=new HashMap<String,String>();
       System.out.print(list);
       for(Admins a:list){
       map.put(a.getUsername(), a.getPassword());
   }
        System.out.print(map);
       if(map.containsKey(username.getText())){
           
           String val2=map.get(username.getText());
           if(val2.equals(password.getText())){
               check.setText("Success..");
               AdminsDB.getConnection();
               Stage primaryStage=new Stage();
               Parent root=FXMLLoader.load(getClass().getResource("ContorlPanel.fxml"));
               Scene scene=new Scene(root,700,500);
        
               primaryStage.setScene(scene);
               primaryStage.show();
               
           }
          else{check.setText("Faild Try Again!!");
           }}
             else{check.setText("Faild Try Again!!");
       
       }}



 public void  singup_login(ActionEvent e)throws IOException,SQLException {
         Stage primaryStage=new Stage();
               Parent root=FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
               Scene scene=new Scene(root,816,460);
        
               primaryStage.setScene(scene);
               primaryStage.show();
     }
  public void GoToSingup(ActionEvent e)throws IOException,SQLException{
        Stage primaryStage=new Stage();
               Parent root=FXMLLoader.load(getClass().getResource("FXMLDocument_1.fxml"));
               Scene scene=new Scene(root);
        
               primaryStage.setScene(scene);
               primaryStage.show();
  }
  
  public void Singup(ActionEvent e)throws IOException,SQLException{
       Stage primaryStage=new Stage();
               Parent root=FXMLLoader.load(getClass().getResource("Singup.fxml"));
               Scene scene=new Scene(root);
        
               primaryStage.setScene(scene);
               primaryStage.show(); 
  }
    public void ViewDrugs(ActionEvent e)throws IOException,SQLException{
       Stage primaryStage=new Stage();
               Parent root=FXMLLoader.load(getClass().getResource("viewdrugs.fxml"));
               Scene scene=new Scene(root);
        
               primaryStage.setScene(scene);
               primaryStage.show(); 
  }
    public void insertDrugs(ActionEvent e)throws IOException,SQLException{
       Stage primaryStage=new Stage();
               Parent root=FXMLLoader.load(getClass().getResource("Insertdrugs.fxml"));
               Scene scene=new Scene(root);
        
               primaryStage.setScene(scene);
               primaryStage.show(); 
  }
        public void DeletDrugs(ActionEvent e)throws IOException,SQLException{
       Stage primaryStage=new Stage();
               Parent root=FXMLLoader.load(getClass().getResource("delete.fxml"));
               Scene scene=new Scene(root);
        
               primaryStage.setScene(scene);
               primaryStage.show(); 
  }
                public void SherchDrugs(ActionEvent e)throws IOException,SQLException{
       Stage primaryStage=new Stage();
               Parent root=FXMLLoader.load(getClass().getResource("Searh.fxml"));
               Scene scene=new Scene(root);
        
               primaryStage.setScene(scene);
               primaryStage.show(); 
  }
                                public void updateDrugs(ActionEvent e)throws IOException,SQLException{
       Stage primaryStage=new Stage();
               Parent root=FXMLLoader.load(getClass().getResource("EditeDrug.fxml"));
               Scene scene=new Scene(root);
        
               primaryStage.setScene(scene);
               primaryStage.show(); 
  }
}
   
    

