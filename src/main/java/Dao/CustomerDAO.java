package Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Customer;

public class CustomerDAO {

  private Connection connection;

  public CustomerDAO() {
    ConnectionClass con = new ConnectionClass();
    try {
      connection = con.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void addCustomer(Customer customer) {
    try {
      String query = "insert into Customer (CustomerID, FirstName, LastName) values ( " + customer.getCustomerId() + ", '" + customer.getFirstName() + "', '" + customer.getLastName() + "')";
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
  public void removeCustomer(int customerid) {
    String query = "delete from Customer where CustomerId = " + customerid;
    try {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public void updateCustomer(Customer customer) {
    String query = "update Customer set FirstName = '" + customer.getFirstName() + "', LastName = '" + customer.getLastName() +"' " + " where CustomerId = " + customer.getCustomerId();
    try {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public ArrayList<Customer> getCustomers() throws SQLException {
    String query = "select * from Customer";
    ArrayList<Customer> customers = new ArrayList<Customer>();
    Statement stmt = connection.createStatement();
    ResultSet res = stmt.executeQuery(query);
    while (res.next()) {
      Customer customer = new Customer();
      customer.setFirstName(res.getString("FirstName"));
      customer.setLastName(res.getString("LastName"));
      customer.setCustomerId(res.getInt("customerid"));
      customers.add(customer);
    }
    return customers;
  }
  public Customer getCustomerById(int customerid) throws SQLException {
    Customer customer = new Customer();
    String query = "select * from Customer where CustomerId = " + customerid + " ";
    Statement stmt = connection.createStatement();
    ResultSet res = stmt.executeQuery(query);
    if (res.next()) {
      customer.setFirstName(res.getString("FirstName"));
      customer.setLastName(res.getString("LastName"));
      customer.setCustomerId(res.getInt("customerid"));
    }
    return customer;
  }
}
