

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author spiro14
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection
{
    Connection con;
    public Connection dbConnect()
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:EC");
        }
        catch(Exception e)
	{
            System.out.print("Exception from database"+ e.getMessage()+"\n"+e.getStackTrace());
	}
        return con;
    }
}
