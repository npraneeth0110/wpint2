import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;
import java.io.*;
import java.sql.*;

@WebServlet("/unregister")
public class Seven extends HttpServlet {
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    PrintWriter out = null;
    try {
      res.setContentType("text/html");
      out = res.getWriter();
      DBConnection.loadDriver();
      Connection con = DBConnection.getConnection();

      String email = (String)req.getParameter("email");
      PreparedStatement ps = con.prepareStatement("DELETE FROM lab_students WHERE emailid=?");
      ps.setString(1, email);

      int n = ps.executeUpdate();
      if(n >= 0) {
        out.println("Successfully Unregistered: " + email);
      }
    } catch(Exception e) {
      out.println("Exception: " + e.getMessage());
    }
  }
}
