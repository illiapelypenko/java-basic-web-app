package Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Seller;

public class SellerDAO {

  private Connection connection;

  public SellerDAO() {
    ConnectionClass con = new ConnectionClass();
    try {
      connection = con.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void addSeller(Seller seller) {
    try {
      String query = "insert into Seller (SellerID, FirstName, LastName, ShowroomID) values ( " + seller.getSellerId() + ", '" + seller.getFirstName() + "', '" + seller.getLastName() + "', " + seller.getShowroomId() + ")";
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
  public void removeSeller(int sellerid) {
    String query = "delete from Seller where SellerId = " + sellerid;
    try {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public void updateSeller(Seller seller) {
    String query = "update Seller set FirstName = '" + seller.getFirstName() + "', LastName = '" + seller.getLastName() +"', " + "ShowroomID" + seller.getShowroomId() + " where SellerId = " + seller.getSellerId();
    try {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public ArrayList<Seller> getSellers() throws SQLException {
    String query = "select * from Seller";
    ArrayList<Seller> sellers = new ArrayList<Seller>();
    Statement stmt = connection.createStatement();
    ResultSet res = stmt.executeQuery(query);
    while (res.next()) {
      Seller seller = new Seller();
      seller.setFirstName(res.getString("FirstName"));
      seller.setLastName(res.getString("LastName"));
      seller.setSellerId(res.getInt("sellerid"));
      seller.setShowroomId(res.getInt("showroomid"));
      sellers.add(seller);
    }
    return sellers;
  }
  public Seller getSellerById(int sellerid) throws SQLException {
    Seller seller = new Seller();
    String query = "select * from Seller where SellerId = " + sellerid + " ";
    Statement stmt = connection.createStatement();
    ResultSet res = stmt.executeQuery(query);
    if (res.next()) {
      seller.setFirstName(res.getString("FirstName"));
      seller.setLastName(res.getString("LastName"));
      seller.setSellerId(res.getInt("sellerid"));
      seller.setShowroomId(res.getInt("showroomid"));
    }
    return seller;
  }
}
