package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

//Will produce a connection object (Factory)
//Singleton - one instance of that object
public class ConnectionFactory {

    private static Connection connection = null;

    //Java won't make a default constructor
    //We won't have access to the constructor outside of the class
    private ConnectionFactory() {}



    //We need 1 public method that returns the connection
    public static Connection getConnection() {
        if (connection == null) {
            //Resource Bundle
            ResourceBundle bundle = ResourceBundle.getBundle("DbConfig");

            //create the connection
            String url = bundle.getString("url");
            String user = bundle.getString("username");
            String password = bundle.getString("password");

            try {
                connection = DriverManager.getConnection(url, user, password);
                return connection;
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }

        return connection;
    }
}
