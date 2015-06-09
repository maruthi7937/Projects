


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

import java.net.ServerSocket;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;


public class ServerMain extends Thread
{
	private final static int BUFSIZE = 20;
	public void run()
	{
            int port = 4555;
            String name = "";
            try
            {
                ServerSocket ss =  new ServerSocket(port);
                System.out.println("Waiting for client.....");
                Socket s = ss.accept();
                {                    
                    DataInputStream opsa=new DataInputStream(s.getInputStream());
                    DataOutputStream out1=new DataOutputStream(s.getOutputStream());	
                    while(true)
                    {
                            String da=opsa.readUTF();
                            System.out.println("Message from Client : "+ da);
                            
                            if(da.equals("release"))
                            {
                                    break;
                            }
                            out1.writeUTF(name);

                            if(name.equals("release"))
                            {
                                    break;
                            }
                    }
                }
            }
            catch (Exception e)
            {
                System.out.println("Exception from server class: " + e.getMessage());
            }
        }
}



