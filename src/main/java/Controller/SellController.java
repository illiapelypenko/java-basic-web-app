package Controller;

import Dao.SellDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Sell;

@WebServlet(name = "SellController", urlPatterns = {"/SellController"})
public class SellController extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private static String insert = "/Sell/SellInsert.jsp";
  private static String edit = "/Sell/SellEdit.jsp";
  private static String list = "/List.jsp";
  private SellDAO selldao;

  public SellController() {
    super();
    selldao = new SellDAO();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String forward = "";
    String action = request.getParameter("action");
    if (action.equalsIgnoreCase("delete")) {
      int sellid = Integer.parseInt(request.getParameter("sellId"));
      selldao.removeSell(sellid);

    } else if (action.equalsIgnoreCase("insert")) {
      forward = insert;
      Sell sell = new Sell();
      request.setAttribute("sell", sell);

    } else if (action.equalsIgnoreCase("edit")) {
      forward = edit;
      int sellid = Integer.parseInt(request.getParameter("sellId"));
      try {
        Sell sell = selldao.getSellById(sellid);
        request.setAttribute("sell", sell);
      } catch (SQLException e) {
        e.printStackTrace();
      }

    } else if(action.equalsIgnoreCase("list")) {
      forward = list;
      try {
        request.setAttribute("sells", selldao.getSells());
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
    Sell sell = new Sell();
    sell.setSellerId(Integer.parseInt(request.getParameter("sellerId")));
    sell.setSellId(Integer.parseInt(request.getParameter("sellId")));
    sell.setShowroomId(Integer.parseInt(request.getParameter("showroomId")));
    sell.setCarId(Integer.parseInt(request.getParameter("carId")));
    sell.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
    if (action.equalsIgnoreCase("insert")) {
      selldao.addSell(sell);
    }
    if (action.equalsIgnoreCase("edit")) {
      selldao.updateSell(sell);
    }
    response.sendRedirect(request.getContextPath() + "/index.jsp");
  }

}