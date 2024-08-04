package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect {
    Statement statement;
    Connection connection;

    public Connect(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","root","root");
            statement = connection.createStatement();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
