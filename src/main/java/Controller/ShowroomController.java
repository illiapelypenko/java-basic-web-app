package Controller;

import Dao.ShowroomDAO;
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
import Model.Showroom;

@WebServlet(name = "ShowroomController", urlPatterns = {"/ShowroomController"})
public class ShowroomController extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private static String insert = "/Showroom/ShowroomInsert.jsp";
  private static String edit = "/Showroom/ShowroomEdit.jsp";
  private static String list = "/List.jsp";
  private ShowroomDAO showroomdao;

  public ShowroomController() {
    super();
    showroomdao = new ShowroomDAO();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String forward = "";
    String action = request.getParameter("action");
    if (action.equalsIgnoreCase("delete")) {
      int showroomid = Integer.parseInt(request.getParameter("showroomId"));
      showroomdao.removeShowroom(showroomid);

    } else if (action.equalsIgnoreCase("insert")) {
      forward = insert;
      Showroom showroom = new Showroom();
      request.setAttribute("showroom", showroom);

    } else if (action.equalsIgnoreCase("edit")) {
      forward = edit;
      int showroomid = Integer.parseInt(request.getParameter("showroomId"));
      try {
        Showroom showroom = showroomdao.getShowroomById(showroomid);
        request.setAttribute("showroom", showroom);
      } catch (SQLException e) {
        e.printStackTrace();
      }

    } else if(action.equalsIgnoreCase("list")) {
      forward = list;
      try {
        request.setAttribute("showrooms", showroomdao.getShowrooms());
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
    Showroom showroom = new Showroom();
    showroom.setAddressId(Integer.parseInt(request.getParameter("addressId")));
    showroom.setShowroomId(Integer.parseInt(request.getParameter("showroomId")));
    if (action.equalsIgnoreCase("insert")) {
      showroomdao.addShowroom(showroom);
    }
    if (action.equalsIgnoreCase("edit")) {
      showroomdao.updateShowroom(showroom);
    }
    response.sendRedirect(request.getContextPath() + "/index.jsp");
  }

}