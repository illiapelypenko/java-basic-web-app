package Controller;

import Dao.SellerDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Seller;

@WebServlet(name = "SellerController", urlPatterns = {"/SellerController"})
public class SellerController extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private static String insert = "/Seller/SellerInsert.jsp";
  private static String edit = "/Seller/SellerEdit.jsp";
  private static String list = "/List.jsp";
  private SellerDAO sellerdao;

  public SellerController() {
    super();
    sellerdao = new SellerDAO();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String forward = "";
    String action = request.getParameter("action");
    if (action.equalsIgnoreCase("delete")) {
      int sellerid = Integer.parseInt(request.getParameter("sellerId"));
      sellerdao.removeSeller(sellerid);
    } else if (action.equalsIgnoreCase("insert")) {
      forward = insert;
      Seller seller = new Seller();
      request.setAttribute("seller", seller);

        } else if (action.equalsIgnoreCase("edit")) {
        forward = edit;
        int sellerid = Integer.parseInt(request.getParameter("sellerId"));
        try {
        Seller seller = sellerdao.getSellerById(sellerid);
        request.setAttribute("seller", seller);
        } catch (SQLException e) {
        e.printStackTrace();
        }
        } else if (action.equalsIgnoreCase("list")) {
        forward = list;
        try {
        request.setAttribute("sellers", sellerdao.getSellers());
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
        Seller seller = new Seller();
        seller.setFirstName(request.getParameter("firstName"));
        seller.setLastName(request.getParameter("lastName"));
        seller.setSellerId(Integer.parseInt(request.getParameter("sellerId")));
        seller.setShowroomId(Integer.parseInt(request.getParameter("showroomId")));
        if (action.equalsIgnoreCase("insert")) {
        sellerdao.addSeller(seller);
        }
        if (action.equalsIgnoreCase("edit")) {
        sellerdao.updateSeller(seller);
        }
        response.sendRedirect(request.getContextPath() + "/index.jsp");
        }

        }