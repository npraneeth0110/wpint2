import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import java.util.*;

@WebServlet("/login")
public class Five extends HttpServlet {
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    PrintWriter out = null;
    try {
      res.setContentType("text/html");
      out = res.getWriter();
      String uname = (String)req.getParameter("uname");
      String psswd = (String)req.getParameter("psswd");

      DBConnection.loadDriver();
      Connection con = DBConnection.getConnection();
      PreparedStatement ps = con.prepareStatement("SELECT * FROM lab_students WHERE uname=? AND passwd=?");
      ps.setString(1, uname);
      ps.setString(2, psswd);
      ResultSet rs = ps.executeQuery();
      if(!rs.next()) {
        out.println("No valid user is found with the given credentials!! please login again");
      } else {
        out.println("Hi " + uname + " you have Successfully logged in");
      }
    } catch(Exception e) {
      out.println("Exception: " + e);
    }
  }
}
