import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;
import java.io.*;
import java.sql.*;

@WebServlet("/insert")
public class Six extends HttpServlet {
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    PrintWriter out = null;
    try {
      res.setContentType("text/html");
      out = res.getWriter();
      String uname = req.getParameter("uname");
      String passwd = req.getParameter("passwd");
      String phno = req.getParameter("phno");
      String emailid = req.getParameter("email");
      DBConnection.loadDriver();
      out.println("Driver Loaded...");
      Connection con = DBConnection.getConnection();
      out.println("Connected to database");
      PreparedStatement ps = con.prepareStatement("INSERT INTO lab_students VALUES(?,?,?,?)");
      ps.setString(1, uname);
      ps.setString(2, passwd);
      ps.setString(3, phno);
      ps.setString(4, emailid);
      int n = ps.executeUpdate();
      if (n > 0) {
        out.println("1 row inserted");
      }
    } catch(Exception e) {
      out.println("error: " + e.getMessage());
    }
  }
}
