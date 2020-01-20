package Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Address;

public class AddressDAO {

  private Connection connection;

  public AddressDAO() {
    ConnectionClass con = new ConnectionClass();
    try {
      connection = con.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void addAddress(Address address) {
      try {
        String query = "insert into Address (AddressID, AddressName) values ( " + address.getAddressId() + ", '" + address.getAddressName() + "' )";
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(query);
      } catch (SQLException e) {
        e.printStackTrace();
      }

  }
  public void removeAddress(int addressid) {
    String query = "delete from Address where AddressId = " + addressid;
    try {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public void updateAddress(Address address) {
    String query = "update Address set AddressName = '" + address.getAddressName() + "' where AddressId = " + address.getAddressId();
    try {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public ArrayList<Address> getAddresses() throws SQLException {
    String query = "select * from Address";
    ArrayList<Address> addresses = new ArrayList<Address>();
    Statement stmt = connection.createStatement();
    ResultSet res = stmt.executeQuery(query);
    while (res.next()) {
      Address address = new Address();
      address.setAddressName(res.getString("AddressName"));
      address.setAddressId(res.getInt("addressid"));
      addresses.add(address);
    }
    return addresses;
  }
  public Address getAddressById(int addressid) throws SQLException {
    Address address = new Address();
    String query = "select * from Address where AddressId = " + addressid + " ";
    Statement stmt = connection.createStatement();
    ResultSet res = stmt.executeQuery(query);
    if (res.next()) {
      address.setAddressName(res.getString("AddressName"));
      address.setAddressId(res.getInt("addressid"));
    }
    return address;
  }
}
