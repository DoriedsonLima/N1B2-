package br.ftt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	
	private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {

                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/ftt?autoReconnect=true&useSSL=false";
                //String user = "scott";
                String user = "root";
                //String password = "tiger";
                String password = "123456";
                           	
            	Class.forName(driver); //verifica se o driver do bd esta no class path...
                
                connection = DriverManager.getConnection(url, user, password);
                
                connection.setAutoCommit(true);
            
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            /*} catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();*/
            }
            return connection;
        }

    }

}
