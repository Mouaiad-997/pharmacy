package pharmacy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBinfo {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/pharm";
            con = DriverManager.getConnection(url, "pharm", "mohamad");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
        return con;
    }

    public static int Save(Drug Dr) {
        int st = 0;

        try {
            String sql = "INSERT INTO `drugs`( `name`, `price`, `themanufacturecompany`, `typeoftreatment`, `thedateofpurchase`, `expirationdate`) VALUES (?,?,?,?,?,?)";
            Connection con = DBinfo.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            preparedStatement.setString(1, Dr.getName());
            preparedStatement.setInt(2, Dr.getPrice());
            preparedStatement.setString(3, Dr.getTheManufactureCompany());
            preparedStatement.setString(4, Dr.getTypeOfTreatment());
            preparedStatement.setString(5, Dr.getTheDateOfPurchase());
            preparedStatement.setString(6, Dr.getExpirationDate());
            st = preparedStatement.executeUpdate();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

    public static int Update(Drug Dr) {
        int st = 0;

        try {
            String sql = "UPDATE `drugs` SET `Name`=?,`The Manufacture Company`=?,`Type of treatment`=?,`The Date of Purchase`=?,`Expiration Date`=? WHERE id=? ";
            Connection con = DBinfo.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            preparedStatement.setString(1, Dr.getName());
            preparedStatement.setString(2, Dr.getTheManufactureCompany());
            preparedStatement.setString(3, Dr.getTypeOfTreatment());
            preparedStatement.setString(4, Dr.getTheDateOfPurchase());
            preparedStatement.setString(5, Dr.getExpirationDate());
            preparedStatement.setInt(6, Dr.getId());

            st = preparedStatement.executeUpdate();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

    public static int Delete(int id) {
        int st = 0;

        try {
            String sql = "DELETE FROM `drugs` WHERE id=?";
            Connection con = DBinfo.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            st = preparedStatement.executeUpdate();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

    public static Drug getDrugID(int id) {
        Drug dr = new Drug();

        try {
            String sql = "SELECT * FROM `drugs` WHERE id=?";
            Connection con = DBinfo.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                dr.setId(resultSet.getInt(1));
                dr.setName(resultSet.getString(2));
                dr.setTheManufactureCompany(resultSet.getString(3));
                dr.setTypeOfTreatment(resultSet.getString(4));
                dr.setTheDateOfPurchase(resultSet.getString(5));
                dr.setExpirationDate(resultSet.getString(6));
            }

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dr;
    }

    public static List<Drug> getDrug() {
        List<Drug> list = new ArrayList<Drug>();

        try {
            String sql = "SELECT * FROM `drugs`";

            Connection con = DBinfo.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Drug Dr = new Drug();
                Dr.setId(resultSet.getInt(1));
                Dr.setName(resultSet.getString(2));
                Dr.setTheManufactureCompany(resultSet.getString(3));
                Dr.setTypeOfTreatment(resultSet.getString(4));
                Dr.setTheDateOfPurchase(resultSet.getString(5));
                Dr.setExpirationDate(resultSet.getString(6));

                list.add(Dr);

            }
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return list;
    }
}
