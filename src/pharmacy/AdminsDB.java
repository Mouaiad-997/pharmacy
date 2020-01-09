package pharmacy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminsDB {

    static Connection con = null;

   
   

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/pharm";
            con = DriverManager.getConnection(url, "pharm", "mohamad");
            System.out.println("connected");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
        return con;
    }

    public static List<Admins> getAdmins() {
        List<Admins> list = new ArrayList<Admins>();
     
        try {
            String sql = "SELECT * FROM `pharmacists`";

            Connection con = AdminsDB.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
           
            while (resultSet.next()) {
                Admins adm = new Admins();
                adm.setId(resultSet.getInt(1));
                adm.setUsername(resultSet.getString(2));
                adm.setPassword(resultSet.getString(6));
                list.add(adm);

            }
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return list;
    }
}
