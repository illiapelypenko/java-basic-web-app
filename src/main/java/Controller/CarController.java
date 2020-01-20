package Controller;

import Dao.CarDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Car;

@WebServlet(name = "CarController", urlPatterns = {"/CarController"})
public class CarController extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private static String insert = "/Car/CarInsert.jsp";
  private static String edit = "/Car/CarEdit.jsp";
  private static String list = "/List.jsp";
  private CarDAO cardao;

  public CarController() {
    super();
    cardao = new CarDAO();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String forward = "";
    String action = request.getParameter("action");
    if (action.equalsIgnoreCase("delete")) {
      int carid = Integer.parseInt(request.getParameter("carId"));
      cardao.removeCar(carid);
    } else if (action.equalsIgnoreCase("insert")) {
      forward = insert;
      Car car = new Car();
      request.setAttribute("car", car);

    } else if (action.equalsIgnoreCase("edit")) {
      forward = edit;
      int carid = Integer.parseInt(request.getParameter("carId"));
      try {
        Car car = cardao.getCarById(carid);
        request.setAttribute("car", car);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } else if (action.equalsIgnoreCase("list")) {
      forward = list;
      try {
        request.setAttribute("cars", cardao.getCars());
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } else {
      forward = insert;
    }
    RequestDispatcher view = request.getRequestDispatcher(forward);
    view.forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    Car car = new Car();
    car.setManufacturerName(request.getParameter("manufacturerName"));
    car.setModelName(request.getParameter("modelName"));
    car.setCarId(Integer.parseInt(request.getParameter("carId")));
    if (action.equalsIgnoreCase("insert")) {
      cardao.addCar(car);
    }
    if (action.equalsIgnoreCase("edit")) {
      cardao.updateCar(car);
    }
    response.sendRedirect(request.getContextPath() + "/index.jsp");
  }

}