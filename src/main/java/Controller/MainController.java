package Controller;

import Dao.AddressDAO;
import Dao.ShowroomDAO;
import Dao.SellerDAO;
import Dao.CustomerDAO;
import Dao.CarDAO;
import Dao.SellDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private static String list = "/List.jsp";
  private AddressDAO addressdao;
  private ShowroomDAO showroomsdao;
  private SellerDAO sellersdao;
  private CustomerDAO customersdao;
  private CarDAO carsdao;
  private SellDAO sellsdao;


  public MainController() {
    super();
    addressdao = new AddressDAO();
    showroomsdao = new ShowroomDAO();
    sellersdao = new SellerDAO();
    customersdao = new CustomerDAO();
    carsdao = new CarDAO();
    sellsdao = new SellDAO();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String forward = list;
    String action = request.getParameter("action");
    if (action.equalsIgnoreCase("list")) {
      forward = list;
      try {
        request.setAttribute("addresses", addressdao.getAddresses());
        request.setAttribute("showrooms", showroomsdao.getShowrooms());
        request.setAttribute("sellers", sellersdao.getSellers());
        request.setAttribute("customers", customersdao.getCustomers());
        request.setAttribute("cars", carsdao.getCars());
        request.setAttribute("sells", sellsdao.getSells());
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    RequestDispatcher view = request.getRequestDispatcher(forward);
    view.forward(request, response);
  }
}