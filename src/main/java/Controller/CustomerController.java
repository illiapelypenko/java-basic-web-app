package Controller;

import Dao.CustomerDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Customer;

@WebServlet(name = "CustomerController", urlPatterns = {"/CustomerController"})
public class CustomerController extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private static String insert = "/Customer/CustomerInsert.jsp";
  private static String edit = "/Customer/CustomerEdit.jsp";
  private static String list = "/List.jsp";
  private CustomerDAO customerdao;

  public CustomerController() {
    super();
    customerdao = new CustomerDAO();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String forward = "";
    String action = request.getParameter("action");
    if (action.equalsIgnoreCase("delete")) {
      int customerid = Integer.parseInt(request.getParameter("customerId"));
      customerdao.removeCustomer(customerid);
    } else if (action.equalsIgnoreCase("insert")) {
      forward = insert;
      Customer customer = new Customer();
      request.setAttribute("customer", customer);

    } else if (action.equalsIgnoreCase("edit")) {
      forward = edit;
      int customerid = Integer.parseInt(request.getParameter("customerId"));
      try {
        Customer customer = customerdao.getCustomerById(customerid);
        request.setAttribute("customer", customer);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } else if (action.equalsIgnoreCase("list")) {
      forward = list;
      try {
        request.setAttribute("customers", customerdao.getCustomers());
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
    Customer customer = new Customer();
    customer.setFirstName(request.getParameter("firstName"));
    customer.setLastName(request.getParameter("lastName"));
    customer.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
    if (action.equalsIgnoreCase("insert")) {
      customerdao.addCustomer(customer);
    }
    if (action.equalsIgnoreCase("edit")) {
      customerdao.updateCustomer(customer);
    }
    response.sendRedirect(request.getContextPath() + "/index.jsp");
  }

}