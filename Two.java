import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class Two {
  public static void main(String[] args) throws Exception {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");

    PreparedStatement ps = con.prepareStatement("SELECT * FROM lab_students");
    ResultSet rs = ps.executeQuery();

    ResultSetMetaData rsmd = rs.getMetaData();

    int col_count = rsmd.getColumnCount();
    System.out.println(col_count);

    while(rs.next()) {
      for(int i = 0; i < col_count; i++)
       System.out.print(rs.getString(i + 1) + "\t");
      System.out.println("");
    }

  }
}
