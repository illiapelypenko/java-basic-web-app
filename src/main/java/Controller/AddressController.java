package Controller;

import Dao.AddressDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Address;

@WebServlet(name = "AddressController", urlPatterns = {"/AddressController"})
public class AddressController extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private static String insert = "/Address/AddressInsert.jsp";
  private static String edit = "/Address/AddressEdit.jsp";
  private static String list = "/List.jsp";
  private AddressDAO addressdao;

  public AddressController() {
    super();
    addressdao = new AddressDAO();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String forward = "";
    String action = request.getParameter("action");
    if (action.equalsIgnoreCase("delete")) {
      int addressid = Integer.parseInt(request.getParameter("addressId"));
      addressdao.removeAddress(addressid);
    } else if (action.equalsIgnoreCase("insert")) {
      forward = insert;
      Address address = new Address();
      request.setAttribute("address", address);

    } else if (action.equalsIgnoreCase("edit")) {
      forward = edit;
      int addressid = Integer.parseInt(request.getParameter("addressId"));
      try {
        Address address = addressdao.getAddressById(addressid);
        request.setAttribute("address", address);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } else if (action.equalsIgnoreCase("list")) {
      forward = list;
      try {
        request.setAttribute("addresses", addressdao.getAddresses());
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
    Address address = new Address();
    address.setAddressName(request.getParameter("addressName"));
    address.setAddressId(Integer.parseInt(request.getParameter("addressId")));
    if (action.equalsIgnoreCase("insert")) {
      addressdao.addAddress(address);
    }
    if (action.equalsIgnoreCase("edit")) {
      addressdao.updateAddress(address);
    }
    response.sendRedirect(request.getContextPath() + "/index.jsp");
  }

}