package Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Car;

public class CarDAO {

  private Connection connection;

  public CarDAO() {
    ConnectionClass con = new ConnectionClass();
    try {
      connection = con.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void addCar(Car car) {
    try {
      String query = "insert into Car (CarID, ManufacturerName, ModelName) values ( " + car.getCarId() + ", '" + car.getManufacturerName() + "', '" + car.getModelName() + "')";
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
  public void removeCar(int carid) {
    String query = "delete from Car where CarId = " + carid;
    try {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public void updateCar(Car car) {
    String query = "update Car set ManufacturerName = '" + car.getManufacturerName() + "', ModelName = '" + car.getModelName() +"' " + " where CarId = " + car.getCarId();
    try {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public ArrayList<Car> getCars() throws SQLException {
    String query = "select * from Car";
    ArrayList<Car> cars = new ArrayList<Car>();
    Statement stmt = connection.createStatement();
    ResultSet res = stmt.executeQuery(query);
    while (res.next()) {
      Car car = new Car();
      car.setManufacturerName(res.getString("ManufacturerName"));
      car.setModelName(res.getString("ModelName"));
      car.setCarId(res.getInt("carid"));
      cars.add(car);
    }
    return cars;
  }
  public Car getCarById(int carid) throws SQLException {
    Car car = new Car();
    String query = "select * from Car where CarId = " + carid + " ";
    Statement stmt = connection.createStatement();
    ResultSet res = stmt.executeQuery(query);
    if (res.next()) {
      car.setManufacturerName(res.getString("ManufacturerName"));
      car.setModelName(res.getString("ModelName"));
      car.setCarId(res.getInt("carid"));
    }
    return car;
  }
}
