/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.net.*;
import java.util.*;
import java.rmi.Naming;
/**
 *
 * @author Admin
 */

public class ClientClass extends Thread
{
    static boolean flagg = false;
    static String nodeName = "";
    static Object o = null;
    static Socket clientSocket = null;
    static TreeMap<String,Object> key=new TreeMap<String, Object>();
	PublicKey pb;
	static String s1;
	MessageReceived msgRcvd;
    
    public ClientClass(String nodeName)
    {
        this.nodeName = nodeName;
        this.setName(nodeName);
        //this.o = o;
    }
    
    
    public void run() 
    {      
        //ObjectInputStream oIp = null;
        try
        {      
			System.out.println("#######--- Clent Socket Started----######");
                this.setName(nodeName);                 
                //InetAddress addr = InetAddress.getLocalHost();			
		SocketAddress sockaddr = new InetSocketAddress(InetAddress.getLocalHost().getHostAddress(), 4555);
		clientSocket = new Socket();                
		clientSocket.connect(sockaddr);
                //StaticClass.setS(clientSocket);
		System.out.println("Connected with Server ");
		String name ="";
                
        System.out.println("Before creating Objects");
                
		DataOutputStream out1=new DataOutputStream(clientSocket.getOutputStream());
		DataInputStream opsa=new DataInputStream(clientSocket.getInputStream());
                               
                System.out.println("After creating Objects");
                System.out.println("Next to write the name to server");
                
                out1.writeUTF(nodeName);
                System.out.println("NodeName written on Server side : " + nodeName);         
                
//                oIp = new ObjectInputStream(clientSocket.getInputStream());
                //oIp = new ObjectInputStream(clientSocket.getInputStream());
                 /////  To read message
		while(true)
                {
					System.out.println("******----Enter client reading part----******");
                       // DataInputStream opsa2=new DataInputStream(clientSocket.getInputStream());
                        String nextSend = opsa.readUTF();
						System.out.println("Client Text received  :" + nextSend );
                         String[] nextSendSplit = nextSend.split("###");
                        int i=1;
                        int j=0;
						byte b1[]=new byte[50];
						String ss=nextSendSplit[0];
						System.out.println("********"+ss+"******");
                        if(ss.equalsIgnoreCase("keys"))
                        {
                            /// reads keys
                            while(i<nextSendSplit.length)
                            {
                               //ClientClass.key.put(nextSendSplit[i++], nextSendSplit[i++]);
							   String s1=nextSendSplit[i];
							   String s2=nextSendSplit[i+1];
							   ClientClass.key.put(s1,s2);
							   System.out.println("####### value 4m map #####"+ClientClass.key.get(s1));
							   // b1=((PrivateKey)((Object)s2)).getEncoded();
							   System.out.println("Text received  : " + s1+" \n"+s2);
							  // new DBClass().insertRow("Neigh",s1,b1,"");
								//System.out.println(if(nextSendSplit[0].equalsIgnoreCase("keys")));
							  KeyRequest.jTxtArea.append("\n"+s1+"\n"+s2);
							  i=i+2;	
                            }
                        }
                        /////////******** reads encrypted messsage  ***********//////////
                       else
                        {
						   		
								String url="rmi://127.0.0.1/ecobj";
								System.out.println("-----EcImpl Called------");
								ECInterface ecIntf=(ECInterface) Naming.lookup(url);
								PrivateKey pr=ecIntf.getPrivate(Main.nod);
								
								System.out.println("-----Private KEY IN NODE------"+pr);
								System.out.println("-----Decryption CALLING------");
								msgRcvd=new MessageReceived();
								MessageReceived.jTextArea1.append(nextSendSplit[1]);
								show(false,nextSendSplit[2]);
								new Decrypt().decryption(nextSendSplit[1],pr,pb);
							
                        }                 
                   
                    
		}
        }
        catch (Exception e)
        {
            System.out.println("Exception from client : " + e.getMessage() + "   :::::   " + e);
            e.printStackTrace();
        }
   }

   static void show(boolean flag,String s)
	{
	   
	   if(!flag)
		   s1=s;
	   else
			 MessageReceived.jTextArea2.append(s1);
	}

    public void writeToServer(String node,String msg)
    {
        try
        {
          
            {
                Socket cliSocket = clientSocket;
                System.out.println(cliSocket);
                DataOutputStream out1 = new DataOutputStream(cliSocket.getOutputStream());
				System.out.println("--write to server--");
				System.out.println("-------------------------------------------------------");
				System.out.println("-------------------------------------------------------");
				System.out.println(":::::"+"message" + "###" + node +"###"+ msg);
                out1.writeUTF("message" + "###" + node +"###"+ msg);
				System.out.println("-------------------------------------------------------");
				System.out.println("-------------------------------------------------------");
            }
           
        }
        catch (Exception ex)
        {
            System.out.println("Exception ::: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}