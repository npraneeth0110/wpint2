import java.sql.*;
public class DBConnection {
  static Connection con = null;
  public static Class loadDriver() throws Exception {
    return Class.forName("oracle.jdbc.driver.OracleDriver");
  }

  public static Connection getConnection() throws Exception{
    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
    return con;
  }
}
