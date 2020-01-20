package Dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
  public Connection getConnection()
          throws SQLException {
    String connectionUrl = "jdbc:sqlserver://localhost;databaseName=CARSHOWROOM;integratedSecurity=true;";
    return DriverManager.getConnection(connectionUrl);
  }
}
