package tosad.businessrule.data;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

@Service
public class JDBC {
    private Connection connection;
    private Properties properties;

    private JDBC(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            connect();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void connect() throws SQLException{
        if(connection == null ){
            connection = DriverManager.getConnection(properties.getProperty("connectionString"), properties.getProperty("user"), properties.getProperty("password"));
        }
    }

    public ResultSet voerQueryUit(String sql){
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            return voerQueryUit(ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ResultSet voerQueryUit(PreparedStatement ps){
        try {
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateQuery(String sql){
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



}
