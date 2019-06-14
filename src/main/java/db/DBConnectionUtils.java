package db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBConnectionUtils {
  public static void main(String args[]) {
    String dataSourceName = "nsn";
    String dbUrl = "jdbc:odbc:" + dataSourceName;
    try {
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      Connection con = DriverManager.getConnection(dbUrl, "root", "12345678");
      Statement s = con.createStatement();
      DatabaseMetaData dbm = con.getMetaData();
      // check if "employee" table is there
      ResultSet tables = dbm.getTables(null, null, "abcd", null);
      boolean exists = false;
      if (tables.next()) {
        exists = true;
        // Table exists
      }
      if (!exists) {
        String query = "create table abcd (name varchar(100));";
        s.execute(query);
        System.out.println("Query executed and table created");
      }
      String query1 = "insert into abc values ('ashit');";
      s.execute(query1);
      System.out.println("Inserted row");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
