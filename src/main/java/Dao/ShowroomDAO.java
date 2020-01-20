package Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Showroom;

public class ShowroomDAO {

  private Connection connection;

  public ShowroomDAO() {
    ConnectionClass con = new ConnectionClass();
    try {
      connection = con.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void addShowroom(Showroom showroom) {
    try {
      String query = "insert into Showroom (ShowroomID, AddressID) values ( " + showroom.getShowroomId() + ", '" + showroom.getAddressId() + "' )";
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
  public void removeShowroom(int showroomid) {
    String query = "delete from Showroom where ShowroomId = " + showroomid;
    try {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public void updateShowroom(Showroom showroom) {
    String query = "update Showroom set AddressID = '" + showroom.getAddressId() + "' where ShowroomId = " + showroom.getShowroomId();
    try {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public ArrayList<Showroom> getShowrooms() throws SQLException {
    String query = "select * from Showroom";
    ArrayList<Showroom> showrooms = new ArrayList<Showroom>();
    Statement stmt = connection.createStatement();
    ResultSet res = stmt.executeQuery(query);
    while (res.next()) {
      Showroom showroom = new Showroom();
      showroom.setAddressId(res.getInt("addressid"));
      showroom.setShowroomId(res.getInt("showroomid"));
      showrooms.add(showroom);
    }
    return showrooms;
  }
  public Showroom getShowroomById(int showroomid) throws SQLException {
    Showroom showroom = new Showroom();
    String query = "select * from Showroom where ShowroomId = " + showroomid + " ";
    Statement stmt = connection.createStatement();
    ResultSet res = stmt.executeQuery(query);
    if (res.next()) {
      showroom.setAddressId(res.getInt("addressid"));
      showroom.setShowroomId(res.getInt("showroomid"));
    }
    return showroom;
  }

}
