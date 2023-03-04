//atm interface using database and swing
import java.sql.*;
public class connection{
    Connection conn;
    Statement stm;
    connection()
    {
      try
      {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","kitcoek");
        stm=conn.createStatement();

        if(conn.isClosed())
        {
            System.out.println("not connected");
        }
        else
        {
            System.out.println("connected");
        }
      }

      catch(Exception e)
      {
        e.printStackTrace();
      }
}

     public static void main(String args[])
     {
      new connection();
     }
}