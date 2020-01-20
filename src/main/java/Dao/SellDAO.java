package Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Sell;

public class SellDAO {

  private Connection connection;

  public SellDAO() {
    ConnectionClass con = new ConnectionClass();
    try {
      connection = con.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void addSell(Sell sell) {
    try {
      String query = "insert into Sell (SellID, SellerID, ShowroomID, CarID, CustomerID) values ( " + sell.getSellId() + ", " + sell.getSellerId() + ", "  + sell.getShowroomId() + ", " + sell.getCarId() + ", " + sell.getCustomerId() + ")";
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
  public void removeSell(int sellid) {
    String query = "delete from Sell where SellId = " + sellid;
    try {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public void updateSell(Sell sell) {
    String query = "update Sell set SellerID = " + sell.getSellerId() + ", ShowroomID = " + sell.getShowroomId() + ", CarID = " + sell.getCarId() + ", CustomerID = " + sell.getCustomerId()  + " where SellId = " + sell.getSellId();
    try {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public ArrayList<Sell> getSells() throws SQLException {
    String query = "select * from Sell";
    ArrayList<Sell> sells = new ArrayList<Sell>();
    Statement stmt = connection.createStatement();
    ResultSet res = stmt.executeQuery(query);
    while (res.next()) {
      Sell sell = new Sell();
      sell.setSellId(res.getInt("sellid"));
      sell.setSellerId(res.getInt("sellerid"));
      sell.setShowroomId(res.getInt("showroomid"));
      sell.setCarId(res.getInt("carid"));
      sell.setCustomerId(res.getInt("customerid"));
      sells.add(sell);
    }
    return sells;
  }
  public Sell getSellById(int sellid) throws SQLException {
    Sell sell = new Sell();
    String query = "select * from Sell where SellId = " + sellid + " ";
    Statement stmt = connection.createStatement();
    ResultSet res = stmt.executeQuery(query);
    if (res.next()) {
      sell.setSellId(res.getInt("sellid"));
      sell.setSellerId(res.getInt("sellerid"));
      sell.setShowroomId(res.getInt("showroomid"));
      sell.setCarId(res.getInt("carid"));
      sell.setCustomerId(res.getInt("customerid"));
    }
    return sell;
  }

}
