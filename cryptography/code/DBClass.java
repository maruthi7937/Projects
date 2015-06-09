

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author spiro14
 *
 * 
 */

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

public class DBClass
{
    Connection con;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;

    public void dropTable(String[] nodeNames) 
    {
        try
	{
		con = new DBConnection().dbConnect();
		stmt=con.createStatement();
                rs = stmt.executeQuery("SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE = 'BASE TABLE' ORDER BY TABLE_NAME" );
                ResultSetMetaData rsmd = rs.getMetaData();        
                String s[] = new String[20];
                int c = 0;
                while(rs.next())
                {
                    s[c] = rs.getString(1);    
                    c+=1;                    
                }
                /*
                 * 
                 */
                
                for (int i = 0; i < nodeNames.length; i++) 
                {
                   
                   //System.out.println("-----------Drop Table-----------" + nodeNames[i] + " ---- " + s[j]);
                    for (int k = 0; k < c; k++) 
                    {
                        if(s[k].equals(nodeNames[i]))
                        {                            
                            stmt.execute("drop table " + nodeNames[i]);                            
                            System.out.println("Dropping the database table " + nodeNames[i]);
                        }
                    }
                   
                }              
        }
        catch(Exception e)
	{
            System.out.println("\nException from database DropTable Method  : "+ e.getMessage()+"\n"+e.getStackTrace());
	}
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    boolean checkExisting(String tName,String value)
    {
        boolean flag = false;
        try
	{
            con = new DBConnection().dbConnect();
            stmt=con.createStatement();
            rs = stmt.executeQuery("select * from " + tName);
            while(rs.next())
            {
                String temp = rs.getString(1);                    
                if(temp.equals(value))
                {
                   flag = true;
                   break;
                }
            }               
        }
        catch(Exception e)
	{
            System.out.print("Exception from database : CheckExisting Class "+ e.getMessage() + e.getStackTrace());
	}
        return flag;
    }
    
    public void clearTable(String tName)
    {
        try
	{
            con = new DBConnection().dbConnect();
            stmt=con.createStatement();
            stmt.executeUpdate("delete " + tName);
            System.out.println("All datas Cleared from table : " + tName);
        }
        catch(Exception e)
	{
            System.out.print("Exception from database"+ e.getMessage()+"\n"+e.getStackTrace());
	}
    }
    
    
    int insertRow(String... value)
    {
        int InputCount = value.length ,flag = 0;
        String tableName = value[0] , insertQuery = "";
        
	try
	{
		con = new DBConnection().dbConnect();
		stmt=con.createStatement();
                ResultSet rs1 = stmt.executeQuery("select * from " + tableName);
                ResultSetMetaData rsmd = rs1.getMetaData();
                int ColumnCount = rsmd.getColumnCount();                
                insertQuery = "insert into " + tableName+ " values(" ;
                
                for (int i = 1; i <= ColumnCount; i++) 
                {
                    if(i != 1)
                        insertQuery += ",";
                    if (value[i] != null)
                    {
                        insertQuery += "'" + value[i] + "'";                        
                    }
                    else
                    {
                        insertQuery += "''";
                    }
                }
                insertQuery += ")";
                System.out.println(insertQuery);
		if(stmt.executeUpdate(insertQuery) == 0)
                {
                    flag = 1;
                }
                con.close();
                
                //System.out.print("Inserted Successfully");
	}
	catch(Exception e)
	{
            System.out.print("Exception from database"+ e.getMessage()+"\n"+e.getStackTrace());
	}
        return flag;
    }


    public int checkLogin(String nName,String pwd)
    {
        int flag = 0;
        try
	{
		con = new DBConnection().dbConnect();
		stmt= con.createStatement();
                rs = stmt.executeQuery("select * from node");
                while(rs.next())
                {
                    String temp = rs.getString(2);                    
                    if(temp.equals(pwd))
                    {
                        flag = 1;
                        break;
                    }
                }
        }
        catch(Exception e)
	{
            System.out.print("Exception from database"+ e.getMessage()+"\n"+e.getStackTrace());
        }
        return flag;
    }
    public void updateRow(String value[])
    {
        try
	{
		con = new DBConnection().dbConnect();
                stmt= con.createStatement();
                stmt.executeUpdate("Update " + value[0] + " set cost='" + value[3] + "' where(startnode='" + value[1] + "' and linknode='" + value[2] + "')");   
        }
        catch(Exception e)
	{
               System.out.print("Exception from database Update Row : "+ e.getMessage()+"\n"+e.getStackTrace());
	} 
    }
    
    public int getRowCount(String tName)
    {
        int a = 0;
        try
	{
		con = new DBConnection().dbConnect();
                stmt= con.createStatement();
                System.out.print(tName);
                ResultSet rs = stmt.executeQuery("select count(*) from " + tName);                
                while (rs.next()) 
                {
                    a = rs.getInt(1);                
                }                
        }
        catch(Exception e)
	{
               System.out.print("Exception from database"+ e.getMessage()+"\n"+e.getStackTrace());
	} 
        return a;
    }
    
    
    public void createTable(String... colValues)
    {
        try
	{
		con = new DBConnection().dbConnect();
		stmt= con.createStatement();
                int a = colValues.length;
                String queryString = "create table " + colValues[0]+ "(";
                for (int i = 1; i < colValues.length; i++) 
                {
                    if(i!=1)
                    {
                        queryString += ",";
                    }
                    queryString += colValues[i] + " varchar(20)";
                }
                queryString += ")";
                System.out.println(queryString);
                stmt.executeUpdate( queryString );             
        }
        catch(Exception e)
	{
            System.out.print("Exception from database"+ e.getMessage()+"\n"+e.getStackTrace());
	}
    }
   
    public void removeRow(String[] values)
    {
        try
	{
                System.out.println( "------======-----");
		con = new DBConnection().dbConnect();
		stmt= con.createStatement();
                int a = stmt.executeUpdate("delete " + values[0] + " where (startnode='" + values[1] + "' and linknode='" + values[2] + "')");
                System.out.println( "------======-----" + a);
        }
        catch(Exception e)
	{
            System.out.print("Exception from database Remove Row : "+ e.getMessage()+"\n"+e.getStackTrace());
	}  
    }
    
    public ResultSet getTableContents(String tName)
    {        
        System.out.println("From Database Class");
        try
	{
		con = new DBConnection().dbConnect();
		stmt= con.createStatement();
                rs = stmt.executeQuery("select * from " + tName);
        }
        catch(Exception e)
	{
            System.out.print("Exception from database"+ e.getMessage()+"\n"+e.getStackTrace());
	}   
        
        return rs;
    }
}
