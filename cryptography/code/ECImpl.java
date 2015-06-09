

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.*;
import java.rmi.server.*;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.sql.*;
import javax.swing.JOptionPane;
public class ECImpl extends UnicastRemoteObject implements ECInterface 
{
        String retVal[]=new String[10];
	public ECImpl() throws RemoteException
	{
	
	}
	public String[] getNodePassword(String node,String stats,String addres,String portNo) throws RemoteException
	{                
		String numPwd="";
		String strings="GANXTHZQVE";
		String stringPwd="";
		String pwd="";
               // String retVal[]=new String[4];
                int n=(node.charAt(4));		
		String ran=Double.toString(Math.random());
		System.out.println(ran);
		for(int i=2;i<ran.length();i=i+5)
		{
			numPwd=numPwd+ran.charAt(i);	
		}
		for(int j=4;j<8;j++)
		{
			stringPwd=stringPwd+strings.charAt(Integer.parseInt(Character.toString(ran.charAt(j))));
		}
		System.out.println("Password is  : "+numPwd);
		System.out.println(stringPwd);
		for(int k=0;k<numPwd.length();k++)
		{
			pwd=pwd+stringPwd.charAt(k)+numPwd.charAt(k);
		}
		System.out.println(pwd);
		try
		{
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						Connection con=DriverManager.getConnection("jdbc:odbc:EC");
                        Statement stmt=con.createStatement();
                        String s=("update node set id='"+pwd+"',flag='1',address='"+addres+"',port='"+portNo+"',status='"+stats+"' where(name='" + node + "')");
                        System.out.println(s);
						stmt.executeUpdate(s);
                        stmt.close();
                         s=("select x,y from node where(name='"+node+"')");
                         Statement stmt1=con.createStatement();
                         ResultSet rs=stmt1.executeQuery(s);
						 System.out.println(s);
                         NewCanvas.picFlag[n-49]=true;
						 System.out.println("Value of n"+(n-48)+"-----"+ Picture.pFlag[n-48]);
						 Picture pic = (Picture) ECServer.o;
						 pic.callMe(2);
						 System.out.println("-------Option2 called from RMI--------");
                         while(rs.next())
                         {
                             retVal[0]=pwd;
                             System.out.println(retVal[0]);
                             retVal[1]=rs.getString(1);
                              System.out.println(retVal[1]);
                             retVal[2]=rs.getString(2);
                              System.out.println(retVal[2]);

                         }
                          System.out.println(s);
						  con.close();
			
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
                if(!stats.equalsIgnoreCase("header"))
                {
                    JOptionPane.showMessageDialog(null, node+" send a registeration request");
                    
                }
		return retVal;
	}
	
	public String getClusterHeadPassword(String clusterHead,String Cluster,String address,String portNo) throws RemoteException
	{
		String numPwd="";
		String strings="SJRFBLMPDK";
		String stringPwd="";
		String pwd="";
		
		String ran=Double.toString(Math.random());
		System.out.println(ran);
		for(int i=2;i<ran.length();i=i+5)
		{
			numPwd=numPwd+ran.charAt(i);	
		}
		for(int j=4;j<8;j++)
		{
			stringPwd=stringPwd+strings.charAt(Integer.parseInt(Character.toString(ran.charAt(j))));
		}
		System.out.println(numPwd);
		System.out.println(stringPwd);
		for(int k=0;k<numPwd.length();k++)
		{
			pwd=pwd+stringPwd.charAt(k)+numPwd.charAt(k);
		}
		System.out.println(pwd);
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:EC");
			PreparedStatement ps=con.prepareStatement("insert into clusterhead_details values(?,?,?,?,?)");
			ps.setString(1,clusterHead);
			ps.setString(2,pwd);
			ps.setString(3,Cluster);
			ps.setString(4,address);
			ps.setString(5,portNo);
			int executed=ps.executeUpdate();
			System.out.println("-------->"+executed+" Row Affected");
			
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return pwd;
	}

	public String[] getClusterHeads() throws RemoteException
	{
		String clusterHeads[]=new String[4];
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:EC");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select distinct * from node where status='Header'");
			int i=0;
			while(rs.next())
			{
				clusterHeads[i]=new String(rs.getString(1).trim());	 
				i++;
			}
			i=0;
		}
		catch (Exception ex1)
		{
			ex1.printStackTrace();
		}
		return clusterHeads;
	}


	public String[] getNodeDetails() throws RemoteException
	{
		String details[]=new String[5];
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:EC");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from node where flag='0'");
            int i=0;
			while (rs.next())
			{
                            details[i++]=rs.getString(1).trim();
			}
			
			con.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return details;
	}

	public String[] getClusterHeadDetails(String category,String clusterHead,String pwd) throws RemoteException
	{
		String details[]=new String[5];
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:EC");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select clusterhead,pwd,cluster,address,portno from clusterhead_details where clusterhead='"+clusterHead+"' and pwd='"+pwd+"'");
			if (rs.next())
			{
				int i=0;
				while(i<5)
					details[i]=rs.getString(++i).trim();
			}
			else
				return null;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return details;
	}

	public String[] getOtherNodes(String sourceNode) throws RemoteException
	{
		String otherNodes[]=new String[10];
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:EC");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select node from node_details where node !='"+sourceNode+"'");
			int i=0;
			while(rs.next())
			{
				otherNodes[i]=rs.getString(1).trim();
				i++;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return otherNodes;
	}

	public String[] getClusterNodes(String sourceClusterHead) throws RemoteException
	{
		String clusterNodes[]=new String[5];
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:EC");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select node from node_details where clusterhead ='"+sourceClusterHead+"'");
			int i=0;
			while(rs.next())
			{
				clusterNodes[i]=rs.getString(1).trim();
				i++;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return clusterNodes;
	}
	

	public String getClusterHeadAddress(String sourceClusterHead) throws RemoteException
	{
		String clusterHeadAddress="";
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:EC");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select address from clusterhead_details where clusterhead ='"+sourceClusterHead+"'");
			if(rs.next())
			{
				clusterHeadAddress=rs.getString(1).trim();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return clusterHeadAddress;
	}


	public int getClusterHeadPortNo(String sourceClusterHead) throws RemoteException
	{
		int clusterHeadPortNo=0;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:EC");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select portno from clusterhead_details where clusterhead ='"+sourceClusterHead+"'");
			if(rs.next())
			{
				clusterHeadPortNo=Integer.parseInt(rs.getString(1).trim());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return clusterHeadPortNo;
	}

	public void setClusterHead(String sourceClusterHead) throws RemoteException
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:EC");
			PreparedStatement ps=con.prepareStatement("insert into cluster_head values(?)");
			ps.setString(1,sourceClusterHead);
			ps.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public String getClusterHead() throws RemoteException
	{
		String clusterHead="";
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:EC");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select clusterhead from cluster_head");
			if(rs.next())
			{
				clusterHead=rs.getString(1).trim();
			}
			Connection con1=DriverManager.getConnection("jdbc:odbc:EC");
			PreparedStatement ps=con1.prepareStatement("truncate table cluster_head");
			ps.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return clusterHead;
	}

	public String[] getClusterDetails(String clusterHead) throws RemoteException
	{
		String details[]=new String[5];
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:EC");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select clusterhead,pwd,cluster,address,portno from clusterhead_details where clusterhead='"+clusterHead+"'");
			if (rs.next())
			{
				int i=0;
				while(i<5)
					details[i]=rs.getString(++i).trim();
			}
			else
				return null;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return details;
	}

        public String[] requestMST(String nod,String ID,String x,String y) throws RemoteException
        {      
			System.out.println("------Request MST-------");
            retVal[0]="";
            retVal[3]="";

            boolean flag=true;
            String s;
            try
            {
                       
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						Connection con=DriverManager.getConnection("jdbc:odbc:EC");
                        Statement stmt=con.createStatement();                     
                         s=("select flag from node");
						 System.out.println(s);
                         ResultSet rs=stmt.executeQuery(s);
                         while(rs.next())
                         {
							 String m=rs.getString(1);
                             if(m.equalsIgnoreCase("0"))
                             {
								 System.out.println("value of flag"+m);
                                 retVal[0]="false";
                                 flag=false;
                                 break;
                             }
                         }  
						 con.close();

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		System.out.println("------Flag value--"+flag);
                if(flag)
                {
					Picture pic = (Picture) ECServer.o;
					pic.callMe(5);
					System.out.println("------getNeighbour Function calling----");
                    retVal=getNeighbour(nod);
                }
                
             return retVal;
        }
        
        public String[] getNeighbour(String nod) throws RemoteException
        {
			System.out.println("-----getNeighbour Function----");
            String st=new String();
            int i=1;
            try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con=DriverManager.getConnection("jdbc:odbc:EC");
            Statement stmt=con.createStatement();
             st=("select distinct * from neighbour where(node='"+nod+"')");
			 System.out.println(st);
             ResultSet rs=stmt.executeQuery(st);
			 System.out.println("-----generateKey1 calling----");
			 generateKey1();

             //i=2;
             while(rs.next())
             {                 
                // while(rs.getString(2)!=null)
                // retVal[i-2]=rs.getString(i);
                 retVal[i]=rs.getString(2);
				 System.out.println("---Value---"+retVal[i++]);
             }
			//retVal[i++]="";
              System.out.println(retVal);
            }
            catch(Exception e)
            {

            }
            return retVal;
        }

		 void generateKey1()
        {
			System.out.println("-----generateKey1 Function---");
			Keygenerator kg=new Keygenerator();
            new DBClass().createTable("keystore","node","public_key","private_key");
            //for(int i=1;i<=NewCanvas.MAXSPOTS;i++)
            {
			   System.out.println("----- Basic generateKey calling----");
               kg.generateKey("node");
               //new DBClass().insertRow("keystore","node"+i,((Object)new Keygenerator().pub).toString(),((Object)new Keygenerator().priv).toString());
            }
        }

        public int requestKey(String nod,String ID,String x,String y) throws RemoteException
        {
			System.out.println("-----Request Key Function------");
            String st="";
            String name="";
            try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con=DriverManager.getConnection("jdbc:odbc:EC");
            Statement stmt=con.createStatement();
             st=("select distinct * from neighbour where(node='"+nod+"')");
			 System.out.println("-----"+st);
             ResultSet rs=stmt.executeQuery(st);
			 int n1=nod.charAt(4);
			 PrivateKey pr1=Keygenerator.priv[n1-48];
             //PublicKey pb1=Keygenerator.pub[n1-48];
			  name="keys"+"### "+nod+"### "+pr1+"###";
		     System.out.println("----- Key value is----"+name);
				// new ServerClass();
             new ServerThread().writeToClient(nod,name);
             //i=2;
             while(rs.next())
             {
                // while(rs.getString(2)!=null)
                // retVal[i-2]=rs.getString(i);                 
                 String temp2 = rs.getString(2);
                 System.out.println("rsVaule" + nod +"   " + temp2);
                 int n=temp2.charAt(4);
                 //PrivateKey pr=Keygenerator.priv[n-48];
                 PublicKey pb=Keygenerator.pub[n-48];
                 name="keys"+"### "+temp2+"### "+pb+"###";
				 System.out.println("----- Key value is----"+name);
				// new ServerClass();
                 new ServerThread().writeToClient(nod,name);

             }
              //write("release");
              //System.out.println(retVal);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }                       
			return 1;
        }

        void write(String name)
        {
            try{
                ServerSocket ss =  new ServerSocket(2134);
                System.out.println("Waiting for client.....");
                Socket s = ss.accept();
                DataOutputStream out1=new DataOutputStream(s.getOutputStream());
                out1.writeUTF(name);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

        public PrivateKey getPrivate(String nod) throws RemoteException
        {
            int i=nod.charAt(4);
            return Keygenerator.priv[i-48];
        }

        public PublicKey getPublic(String nod) throws RemoteException
        {
            int i=nod.charAt(4);
            return Keygenerator.pub[i-48];
        }

}
