package pharmacy;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.cell.PropertyValueFactory;


public class ViewDrugs implements Initializable {

    @FXML
    private TableView<Drug> table;
    @FXML
    private TableColumn<Drug, Integer> id;
    @FXML
    private TableColumn<Drug, String> name;
    @FXML
    private TableColumn<Drug, String> themanufacturecompany;
    @FXML
    private TableColumn<Drug, String> typeoftreatment;
    @FXML
    private TableColumn<Drug, String> thedateofpurchase;
    @FXML
    private TableColumn<Drug, String> expirationdate;
    public ObservableList<Drug> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            String sql = "SELECT * FROM `drugs`Where 1";

            Connection con = DBinfo.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                data.add(new Drug(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
            
       

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        id.setCellValueFactory(new PropertyValueFactory<Drug, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Drug, String>("name"));
        themanufacturecompany.setCellValueFactory(new PropertyValueFactory<Drug, String>("themanufacturecompany"));
        typeoftreatment.setCellValueFactory(new PropertyValueFactory<Drug, String>("typeoftreatment"));
        thedateofpurchase.setCellValueFactory(new PropertyValueFactory<Drug, String>("thedateofpurchase"));
        expirationdate.setCellValueFactory(new PropertyValueFactory<Drug, String>("expirationdate"));
        table.setItems(data);
    }

   
}
