package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class DatabaseConfigurationUtil {

  Logger logger = Logger.getLogger("MyLog");

  public void generateLogFile() {
    FileHandler fh;
    try {
      // This block configure the logger with handler and formatter
      fh = new FileHandler("D:\\MyLogFile.log");
      logger.addHandler(fh);
      SimpleFormatter formatter = new SimpleFormatter();
      fh.setFormatter(formatter);
      // the following statement is used to log any messages
      logger.info("My first log");
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    logger.info("Hi How r u?");
  }

  public Connection setupConnection() {
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      System.out.println("Class not founded");
      e.printStackTrace();
    }
    Connection connection = null;
    try {
      connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shopping_cart",
          "postgres", "postgres");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println("Connection not created");
      e.printStackTrace();
    }
    if (connection != null) {
      System.out.println("Connection created");
    }
    return connection;
  }

  public void closeConnection(Connection connection) {

    try {
      connection.close();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public boolean createTable(String sql) {
    boolean b = false;
    Statement stmt = null;
    Connection con = null;
    try {
      con = this.setupConnection();
      stmt = con.createStatement();
      if (stmt != null && con != null)
        stmt.executeUpdate(sql);
      else
        throw new NullPointerException();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        stmt.close();
        this.closeConnection(con);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return b = true;
  }

  public void insertIntoTable(String sql) {
    Connection c = null;
    Statement stmt = null;
    try {
      c = this.setupConnection();
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      stmt.executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        stmt.close();
        c.commit();
        c.close();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  public void deleteFromTable(String sql) {

  }

  public void updateTable(String sql) {

  }

  public void createTableSQL() {
    String sql = "CREATE TABLE COMPANY " + "(ID INT PRIMARY KEY     NOT NULL,"
        + " NAME           TEXT    NOT NULL, " + " AGE            INT     NOT NULL, "
        + " ADDRESS        CHAR(50), " + " SALARY         REAL)";
    if (createTable(sql)) {
      System.out.println("Table Created");
    }
    insertIntoTable("INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
        + "VALUES (1, 'Paul', 32, 'California', 20000.00 );");
    insertIntoTable("INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
        + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );");
    insertIntoTable("INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
        + "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );");
    insertIntoTable("INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
        + "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );");

  }

  public void getData() {
    String sql = "select * from userList";
    ResultSet rs = retrieveData(sql);
    displayData(rs);
  }

  public void displayData(ResultSet rs) {
    try {
      while (rs.next()) {
        System.out.print(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
        System.out.println("");
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public ResultSet retrieveData(String sql) {
    Connection c = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
      c = this.setupConnection();
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      rs = stmt.executeQuery(sql);
    } catch (SQLException e) {
    }
    return rs;
  }

  public static void main(String[] args) {

    DatabaseConfigurationUtil obj = new DatabaseConfigurationUtil();
    obj.getData();
  }
}
